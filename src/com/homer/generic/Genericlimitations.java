package com.homer.generic;

import jdk.nashorn.internal.ir.Block;

import java.util.Arrays;
import java.util.function.IntFunction;

public class Genericlimitations {

    /**
     * IntFunction<R>带一个int参数的supplier。
     * @param inf
     * @param a
     * @param <T>
     */
    public static <T extends Comparable> T[] minMax(IntFunction<T[]> inf, T... a) {

        T[] mm = inf.apply(2);//传入一个参数到函数式接口，在这里是指控制数据组的大小

        T min = a[0];
        T max = a[0];
        for (T x : a) {
            if(x.compareTo(min) <= 0) min = x;
            if(x.compareTo(max) >= 0) max = x;
        }

        mm[0] = min;
        mm[1] = max;
        return mm;
    }

    public static void main(String[] args) {
        //lambda可以替代为String[]::new
        String[] minmax = Genericlimitations.minMax((x) -> new String[x], "f", "a", "z");
        System.out.println(Arrays.toString(minmax));

    }
}


