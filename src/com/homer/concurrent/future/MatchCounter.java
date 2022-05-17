package com.homer.concurrent.future;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MatchCounter implements Callable<Integer> {

    private File searchDir;
    private String keyWord;

    public MatchCounter(File searchDir, String keyWord) {
        this.searchDir = searchDir;
        this.keyWord = keyWord;
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

    @Override
    public Integer call() throws Exception {
        File[] files = searchDir.listFiles();
        List<Future<Integer>> results = new ArrayList<>();
        if(files == null)
            return 0;

        int count = 0 ;
        for (File file : files) {
            if (file.isDirectory()) {
                MatchCounter counter = new MatchCounter(file, keyWord);
                FutureTask<Integer> task = new FutureTask<>(counter);
                results.add(task);//每个目录建一个任务，然后放进集合
                Thread thread = new Thread(task);
                thread.start();
            } else {
                if (search(file)) count++;
            }
        }

        for (Future<Integer> result : results) {
            count += result.get();
        }

        return count;
    }
}
