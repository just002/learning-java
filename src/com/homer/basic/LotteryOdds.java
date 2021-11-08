package com.homer.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 从java核心技术：卷1中拿过来的例子
 * 计算从N个数里面抽取K个数，一共有多少种可能性
 */
public class LotteryOdds {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("一共多少个数字：");
        int max = scanner.nextInt();

        System.out.print("抽几个数字：");
        int gets = scanner.nextInt();

        int peilv = 1;

        for(int i = 1; i <= gets; i++) {
            peilv = peilv * ( max - i + 1)/i;
        }

        System.out.println("赔率是：" + peilv);



//        int[] a = {14,2,22,4,5};
//        Arrays.sort(a);
//        int b[];
//
//        b = Arrays.copyOf(a,10);
//
//        for (int x:a) {
//            System.out.println(x);
//        }

//        for(int i = 0; i < 10; i++) {
//            System.out.println((int)(Math.random() * 5));
//        }


    }
}
