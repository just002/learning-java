package com.homer.basic;

public class Peeler {

    public static Apple peel(Apple apple){
        System.out.println("削皮！");
        apple.setPeeled(true);
        return apple;
    }
}
