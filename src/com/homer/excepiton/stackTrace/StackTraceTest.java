package com.homer.excepiton.stackTrace;

import java.util.Scanner;

public class StackTraceTest {

    /**
     * 实现递归阶乘：1*2*3*4……*n
     * @param x
     * @return
     */
    public static int factorial(int x) {

        System.out.println("factorial(" + x + ")");

        //堆栈轨迹是从当前线程中取出的
        Throwable t = new Throwable();
        StackTraceElement[] ste = t.getStackTrace();
        for( StackTraceElement e: ste) {
            System.out.println(e);
        }

        /**
         * 递归和循环是一个道理，必须有一个截止的条件。比如本例就是从一个整数递减，直到x <= 1直接返回1。
         * 一开始，我写成x + 1递增，就永远不会满足x<=1而导致报了StackOverflowError
         */
        int result;
        if(x <= 1)
            result = 1;
        else
            result = x * factorial(x - 1);

        System.out.println("return " + result);

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个需要计算阶乘的数：");
        int input = scanner.nextInt();

        System.out.println("1-" + input + "的阶乘结果为：" + factorial(input));
    }

}
