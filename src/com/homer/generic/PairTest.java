package com.homer.generic;

import com.homer.ClassAndObject.*;
import java.util.Date;

public class PairTest {

//    public static Pair<Double> getMaxMin(double[] arr) throws Exception {
//        if(arr == null || arr.length == 0)
//            throw new Exception("错误的参数（数据为空）");
//
//        double max = arr[0];
//        double min = arr[0];
//        for (double x : arr) {
//            if(x > max) max = x;
//            if(x < min) min = x;
//        }
//
//        return new Pair<>(min, max);
//    }

//    public static Pair<String> getMaxMin(String[] arr) throws Exception {
//        if(arr == null || arr.length == 0)
//            throw new Exception("错误的参数（数据为空）");
//
//        String max = arr[0];
//        String min = arr[0];
//
//        for (String x : arr) {
//            if(x.compareTo(max) > 0) max = x;
//            if(x.compareTo(min) < 0) min = x;
//        }
//
//        return new Pair<>(min, max);
//    }


    /**
     * 以上两个方法用一个泛型方法直接替代了。
     * 那么，现在这个方法的应用就非常广泛了，支持任何实现Comparable接口的对象来调用本方法
     * @param arr
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T extends Comparable> Pair<T> getMaxMin(T[] arr) throws Exception {
        if(arr == null || arr.length == 0)
            throw new Exception("错误的参数（数据为空）");

        T max = arr[0];
        T min = arr[0];

        for (T x : arr) {
            if(x.compareTo(max) > 0) max = x;
            if(x.compareTo(min) < 0) min = x;
        }

        return new Pair<>(max, min);
    }

    public static void main(String[] args) throws Exception {
        int arrSize = 10;
        Double[] testArr = new Double[arrSize];
        for(int i = 0; i < arrSize; i++)
            testArr[i] = Math.random() * 100;
        Pair<Double> pair = getMaxMin(testArr);
        System.out.println("最小：" + pair.getFirst());
        System.out.println("最大：" + pair.getSecond());


        String[] testStr = new String[] {"homer", "Panda" ,"zozo", "yoyo", "aaaaaa"};
        Pair<String> pair1 = getMaxMin(testStr);
        System.out.println("最小：" + pair1.getFirst());
        System.out.println("最大：" + pair1.getSecond());

        //System.out.println("b".compareTo("B"));

        Employee x = new Employee("zhangfei", new Date(), 100);
        Employee y = new Employee("liubei", new Date(), 150000);
        Employee z = new Employee("guanyu", new Date(), 2000);
        Employee[] employees = {x,y,z};
        Pair<Employee> pair2 = getMaxMin(employees);
        System.out.println("最小：" + pair2.getFirst());
        System.out.println("最大：" + pair2.getSecond());
    }
}
