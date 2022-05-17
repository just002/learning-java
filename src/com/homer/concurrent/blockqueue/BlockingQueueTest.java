package com.homer.concurrent.blockqueue;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

    private static BlockingQueue<File> blockingQueue = new ArrayBlockingQueue(10);
    private static File DUMMY = new File("");

    // 遍历目录，并装载文件。采用recursive call（递归）方式层层遍历加载文件到堵塞队列
    // 阻塞队列的机制，当装载内容达到上限，线程会进入阻塞状态
    private static void loadDir(File dir) throws InterruptedException {
        File[] files = dir.listFiles();
        for (File file : files) {
            if(file.getName().startsWith(".")) {
                continue;
            }

            if(!file.isDirectory()) {
                blockingQueue.put(file);
                //System.out.println(Thread.currentThread() + ": put-->" + file.getPath() + "-->" + blockingQueue.size());
            } else {
                //System.out.println(Thread.currentThread() + ": 进入目录：" + file.getPath());
                loadDir(file);
            }
        }
    }

    //搜索
    private static synchronized void search(String keyWord, File file) throws IOException {
        //System.out.println(Thread.currentThread() + ": search: " + file.getPath());
        InputStreamReader is = new FileReader(file);
        BufferedReader br = new BufferedReader(is);
        String line;
        int row = 1;
        while ((line = br.readLine()) != null) {
            if(line.contains(keyWord)) {
//                System.out.println( "****关键字[" + keyWord + "]出现在文件[" + file.getPath() + "]的"
//                        + row + "行" + new LineFinder().getPositions(line, keyWord) + "列 \n"
//                        + line.replace(keyWord,"*"+keyWord+"*"));
                System.out.printf( "****关键字[%s]出现在文件[%s]的%d行%s列\n",keyWord,file.getPath(),row, new LineFinder().getPositions(line, keyWord));
                System.out.printf("原文：%s\n", line.replace(keyWord,"*"+keyWord+"*"));
            }
            row++;
        }
    }



    public static void main(String[] args) {

        String dir = System.getProperty("user.dir");
        String keyWord = "Homer";
        int threadNum = 5;

        new Thread(() -> {
            try {
                loadDir(new File(dir));
                //妙啊！这里放一个假人的目的是，为了让线程知道何时结束
                blockingQueue.put(DUMMY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        for (int i=0; i<threadNum; i++) {
            new Thread(() -> {
                try {
                    boolean done = false;
                    while (!done) {
                        File file = blockingQueue.take();
                        //System.out.println(Thread.currentThread() + ": take: " + file.getPath() + "-->" + blockingQueue.size());
                        if(file == DUMMY) {
                            // 如果取到DUMMY说明队列已经没有数据进来了，循环结束。
                            // 还要重新放入DUMMY的目的是为了然其他线程也知道结束了，否则只能结束本线程，其他线程永远得不到通知
                            blockingQueue.put(DUMMY);
                            done = true;
                        } else
                            search(keyWord, file);
                    }

                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
