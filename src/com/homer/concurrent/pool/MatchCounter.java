package com.homer.concurrent.pool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MatchCounter implements Callable<Integer> {
    private File searchDir;
    private String keyWord;
    private ExecutorService pool;

    private int count;

    public MatchCounter(File searchDir, String keyWord, ExecutorService pool) {
        this.searchDir = searchDir;
        this.keyWord = keyWord;
        this.pool = pool;
    }

    @Override
    public Integer call() throws Exception {

        List<Future<Integer>> results = new ArrayList<>();

        File[] files = searchDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                MatchCounter counter = new MatchCounter(file, keyWord, pool);
                results.add(pool.submit(counter));
            } else {
                if(search(file)) count++;
            }
        }

        for(Future<Integer> result : results) {
            count = count + result.get();
        }
        return count;
    }

    private boolean search(File file) {
        System.out.printf("[%s] Search File [%s]\n", Thread.currentThread(), file.getName());
        boolean result = false;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                if(scanner.next().contains(keyWord))
                    result = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }
}
