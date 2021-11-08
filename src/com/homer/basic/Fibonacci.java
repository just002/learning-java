package com.homer.basic;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Fibonacci {

    //private static final int startnum = 1;
    private static int lastnum = 1;
    private static int lalastnum = 1;

//    private static int[] arr={1,1};

    public static void printFibonacci(int end){
        System.out.print(lalastnum + " ");
        System.out.print(lastnum + " ");

        for(int i = 2; i <= end; i++){
            if(i == lalastnum + lastnum){
                System.out.print(i + " ");
                lalastnum = lalastnum + lastnum;
                lastnum = i - lastnum;
            }

        }
    }

    //返回指定个数的斐波那契数字
    public static void printFibonacci1(int count){

        int[] arr={1,1};

        for(int i = 0; i<count-2; i++){
            arr = getFibonacciArray(arr);
        }


        for (int n: arr ) {
            System.out.print(n + " ");
        }
    }

    public static int[] getFibonacciArray(int[] son){

        if(son.length < 2 && son[0] == 1){
            return new int[]{1,1};
        }
        int lastNum = son[son.length - 1] + son[son.length - 2];//计算出最后一个数据
        int[] father = new int[son.length + 1];
        for(int i=0; i<son.length; i++){
            father[i] = son[i];
        }
        father[son.length] = lastNum;
        return father;
    }

    //
    //5 f(5) = f(4) + f(3)
    //4 f(4) = f(3) +　f(2)
    //3 f(3) = f(2) + f(1)
    //2 f(2) = f(1) + f(0) = 1 + 1

    static int fib(int n){
        if(n < 2) return 1;
        return (fib(n - 1) + fib(n - 2));
    }


    //5+4+3…… 函数的递归调用
    //5 f(5) = 5+f(4)
    //4 f(4) = 4+f(3)
    //3 f(3) = 3+f(2)
    //2 f(2) = 2+f(1) = 2 + 1
    static int f(int n){
        if(n < 2)
            return 1;
        return n + f(n-1);
    }


    public static void main(String[] args){
//        printFibonacci(10000);

        //Fibonacci f = new Fibonacci();
        //System.out.println(fib(5));

//        int end = 10;
//        for(int i=0; i<6; i++){
//            System.out.print(fib(i) + " ");
//
//        }

//        printFibonacci1(30);

    System.out.print(f(122));

    }
}
