package com.homer.generic;

import java.util.Arrays;

public class PairTest {

    public static Pair<Double> getMaxMin(double[] arr) throws Exception {
        if(arr == null || arr.length == 0)
            throw new Exception("错误的参数（数据为空）");

        double max = arr[0];
        double min = arr[0];
        for (double x : arr) {
            if(x > max) max = x;
            if(x < min) min = x;
        }

        return new Pair<>(min, max);
    }

    public static Pair<String> getMaxMin(String[] arr) throws Exception {
        if(arr == null || arr.length == 0)
            throw new Exception("错误的参数（数据为空）");

        String max = arr[0];
        String min = arr[0];

        for (String x : arr) {
            if(x.compareTo(max) > 0) max = x;
            if(x.compareTo(min) < 0) min = x;
        }

        return new Pair<>(min, max);
    }

    public static void main(String[] args) throws Exception {
        int arrSize = 10;
        double[] testArr = new double[arrSize];
        for(int i = 0; i < arrSize; i++)
            testArr[i] = Math.random() * 100;

        System.out.println(Arrays.toString(testArr));

        Pair<Double> pair = getMaxMin(testArr);

        System.out.println("最小：" + pair.getFirst());
        System.out.println("最大：" + pair.getSecond());


        String[] testStr = new String[] {"homer", "Panda" ,"zozo", "yoyo", "aaaaaa"};
        Pair<String> pair1 = getMaxMin(testStr);

        System.out.println("最小：" + pair1.getFirst());
        System.out.println("最大：" + pair1.getSecond());

        System.out.println("b".compareTo("B"));
    }
}
