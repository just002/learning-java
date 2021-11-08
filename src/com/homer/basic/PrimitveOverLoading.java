package com.homer.basic;

public class PrimitveOverLoading {
    static void f1(char x) {
        System.out.println("f1(char x)");
    }

    static void f1(byte x) {
        System.out.println("f1(byte x)");
    }


    static void f1(short x) {
        System.out.println("f1(short x)");
    }


    static void f1(int x) {
        System.out.println("f1(int x)");
    }

    public static void main(String[] args){
        f1('a');
    }
}
