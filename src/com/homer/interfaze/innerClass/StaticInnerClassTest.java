package com.homer.interfaze.innerClass;

import java.util.Arrays;

public class StaticInnerClassTest {

    private static final int arrSize = 10;

    public static void main(String[] args) throws Exception {

        double[] testArr = new double[arrSize];
        for(int i = 0; i < arrSize; i++)
            testArr[i] = Math.random() * 100;

        System.out.println(Arrays.toString(testArr));

        ArrayAlg.Pair pair = ArrayAlg.getMaxAndMin(testArr);

        System.out.println("最小：" + pair.getFirst());
        System.out.println("最大：" + pair.getSecond());
    }

}

class ArrayAlg {

    static class Pair {
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    public static Pair getMaxAndMin(double[] arr) throws Exception {
        if(arr == null || arr.length == 0)
            throw new Exception("错误的参数（数据为空）");


        double min = Double.POSITIVE_INFINITY; //正无穷大，任何数都小于它
        double max = Double.NEGATIVE_INFINITY; //负无穷大，任何数都大于它

        /**
         * 此处写法差异，我是将数组的第一个元素进行初始化，应该也没有问题。
         * 但是作者直接用户Double.POSITIVE_INFINITY、Double.NEGATIVE_INFINITY两个常数，逻辑更加严密一些
         */

//        double max = arr[0];
//        double min = arr[0];
        for (double x : arr) {
            if(x > max) max = x;
            if(x < min) min = x;
        }

        return new Pair(min, max);
    }
}
