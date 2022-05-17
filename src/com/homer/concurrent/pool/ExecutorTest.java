package com.homer.concurrent.pool;

import java.io.File;
import java.util.concurrent.*;

public class ExecutorTest {

    public static void main(String[] args) {

        String dir = System.getProperty("user.dir");
        String keyWord = "Homer";

        ExecutorService pool = Executors.newCachedThreadPool();
        MatchCounter counter = new MatchCounter(new File(dir), keyWord, pool);
        Future<Integer> task = pool.submit(counter);

        try {
            System.out.printf("[%s]文件夹包含关键字'%s'的文件数为[%d]\n", dir,keyWord, task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        pool.shutdown();

        System.out.printf("线程数 --> %s", ((ThreadPoolExecutor)pool).getLargestPoolSize());

    }
}
