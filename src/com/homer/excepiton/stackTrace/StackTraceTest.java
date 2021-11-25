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

        Throwable t = new Throwable();
        StackTraceElement[] ste = t.getStackTrace();
        for( StackTraceElement e: ste) {
            System.out.println(e);
        }

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
