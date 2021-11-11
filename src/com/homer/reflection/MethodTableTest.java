package com.homer.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTableTest {
    public static void main(String[] args) {
        try {
            //如果是private方法，需要用getDeclaredMethod()
            Method square = MethodTableTest.class.getDeclaredMethod("square", double.class);
            printTable(1,10, square);
            printTable(1,10, 5, square);

            //double.class与Double.class不同
            Method sqrt = Math.class.getMethod("sqrt", double.class);
            printTable(10,50, sqrt);
            printTable(1,10, 5, square);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static double square(double x) {
        return x * x;
    }

    /**
     * @author Homer Wang
     * @param from 开始
     * @param to 结束
     * @param method 执行的方法
     */
    public static void printTable(double from, double to, Method method)
            throws InvocationTargetException, IllegalAccessException {
        for(double i = from; i <= to; i++) {
            //invoke()是两个参数，第一个是所属对象（静态的传入null），后面是方法的参数列表。
            double j = (double)method.invoke(null,i);
            System.out.printf("%10.4f | %10.4f\n", i, j);

        }

    }

    /**
     * 作者的方法加入参数n，表示需要打印表格行数，而不是机械的+1.
     * 然后在根据行数计算计算出步长: dx = (to - from)/(n - 1)
     * @param from
     * @param to
     * @param n
     * @param method
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void printTable(double from, double to, int n, Method method)
            throws InvocationTargetException, IllegalAccessException {
        //步长
        double dx = (to - from)/(n - 1);

        System.out.println("步长dx-->" + dx);
        for(double i = from; i <= to; i+=dx) {
            double j = (double)method.invoke(null,i);
            //作者使用%n实现换行，看起来与\n没有本质区别
            System.out.printf("%10.4f | %10.4f%n", i, j);

        }

    }
}
