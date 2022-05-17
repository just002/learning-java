package com.homer.concurrent.future;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {

    public static void main(String[] args) {

        String dir = System.getProperty("user.dir");
        String keyWord = "Homer";

        MatchCounter counter = new MatchCounter(new File(dir), keyWord);

        /**
         * 此处直接调用Callable的call方法也能执行，FutureTask的方法更加丰富能够进行更细粒度的控制
         */
//        try {
//            System.out.printf("[%s]文件夹包含关键字'%s'的文件数为[%d]", dir,keyWord, counter.call());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        FutureTask<Integer> task = new FutureTask<>(counter);
        Thread thread = new Thread(task);
        thread.start();
        try {
            System.out.printf("[%s]文件夹包含关键字'%s'的文件数为[%d]", dir,keyWord, task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
