package com.homer.basic;

import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("输入需要抽取的最大数字：");
        int max = scanner.nextInt();

        System.out.println("输入需要抽取的数字个数：");
        int draw = scanner.nextInt();

        int[] pool = new int[max];
        for(int i = 0; i < max; i ++) {
            pool[i] = i + 1;
        }

        int[] result = new int[draw];
        for(int i = 0; i < draw; i++) {

            int r = (int)(Math.random() * max);//获得随机下标
            result[i] = pool[r];//赋值给结果数组

            pool[r] = pool[max - 1];//用还没被抽到的数的值（这里是用目前下标最大的数据去覆盖）把已经抽过的数覆盖了，那么后面再也不会抽到这个数据。但是我觉得会影响概率，并不是好的做法

            max--;

            //Arrays.sort(pool);

            System.out.println("数据池：");
            for(int x : pool) {
                System.out.print(x + ",");
            }
        }

//        System.out.println("数据池：");
//        for(int x : pool) {
//            System.out.print(x + ",");
//        }

        System.out.println("\n你抽到的：");
        for(int x : result) {
            System.out.print(x + ",");
        }

    }
}
