package com.homer.basic;

public class WhileTest {

    static int num = 0;
    static boolean condtion(){
        boolean result = Math.random() < 0.99;
        System.out.println(num++ + ":" + result + ".");
        return result ;
    }

    public static void main(String[] args){
        while(condtion())
            System.out.println("循环……");
        System.out.println("循环结束……");
    }
}
