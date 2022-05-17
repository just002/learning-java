package com.homer.concurrent;

public class Mytest {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.printf("[%s]支线2-->%s\n",Thread.currentThread(),System.currentTimeMillis());
        }).start();


        System.out.printf("[%s]1-->[%s]\n",Thread.currentThread(), System.currentTimeMillis());

        new Thread(() -> {
            System.out.printf("[%s]支线1-->%s\n",Thread.currentThread(),System.currentTimeMillis());
        }).start();

        System.out.printf("[%s]2-->[%s]\n",Thread.currentThread(), System.currentTimeMillis());
        System.out.printf("[%s]3-->[%s]\n",Thread.currentThread(), System.currentTimeMillis());


    }
}
