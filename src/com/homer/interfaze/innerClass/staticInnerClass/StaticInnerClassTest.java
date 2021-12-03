package com.homer.interfaze.innerClass.staticInnerClass;

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


