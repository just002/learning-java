package com.homer.generic;

public class GenericMethod {

    /**
     * 用可变参数要更加一些，因为同时兼容数据和多个参数。而我是直接用的数组。
     * 泛型方法的菱形修饰符位于-->方法的修饰符之后，返回值之前。
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> T getMiddle(T... arr) {
        return arr[arr.length / 2];
    }

    public static <T> void getMiddle1(T... arr) {

    }

    public static void main(String[] args) {
        System.out.println(GenericMethod.<String>getMiddle(new String[] {"a","b","c","d","e"}));

        //<Integer>通常是被省略的，编译器可以直接推断出。
        double middle = GenericMethod.<Integer>getMiddle(1,2,3,4,5,6,7,8,9,10);
        System.out.println(middle);
    }
}
