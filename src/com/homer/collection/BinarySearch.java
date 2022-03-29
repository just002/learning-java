package com.homer.collection;


import java.util.*;

public class BinarySearch {

    private static final Random random = new Random();

    private static Map<Integer, Integer> map;

    public static void main(String[] args) {
        int size = 100;
        int[] sortedArr = new int[size];
        //random.nextInt(10000);
        sortedArr[0] = random.nextInt(10);
        for (int i = 1; i < sortedArr.length; i++) {
            sortedArr[i] = sortedArr[i - 1] + random.nextInt(10);
        }


        //System.out.println(Arrays.toString(sortedArr));

        System.out.println("找到了！对应下标为：" + find(sortedArr, 300));


        //int[] a = {1,2,3,4,5};
        /**
         * 奇怪：from是下标值，但是to又不是下标，而是到第几个
         */
        //System.out.println(Arrays.toString(Arrays.copyOfRange(a, 3, 5)));

    }

    /**
     * 获取一个确定范围内的随机数
     * @param min
     * @param max
     * @return
     */
    private static int getRandom(int min, int max) {
        int r;
        while (true) {
            r = random.nextInt(max);
            if(r > min)
                return r;
        }
    }


    /**
     * 返回查找元素的下标值。其实还没有考虑两个相邻的数一样的情况，目前只能找到其中一个的下标值
     * @param arr
     * @param x
     * @return
     */
    private static int find(int[] arr, int x) {

        //用此MAP记住查找元素的原始位置
        if(map == null) {
            map = new HashMap<>();
            for(int i = 0; i < arr.length; i++)
                map.put(arr[i], i);
        }

        System.out.println(Arrays.toString(arr) + "-->" + x);

        //空數組直接返回-1
        if(arr == null || arr.length == 0)
            return -1;

        //如果数组只有一个元素
        if(arr.length == 1)
            return x == arr[0] ? map.get(x) : -1;

        //如果数组只有两个元素
        if(arr.length == 2)
            return (arr[0] == x || arr[1] == x) ? map.get(x) : -1;

        //超过两个元素
        int middle = arr.length / 2;
        int result = arr[middle];
        if(x == result) return map.get(x);
        if(x > result) {
            int[] arrTemp = Arrays.copyOfRange(arr, middle + 1, arr.length);
            return find(arrTemp, x);
        }
        else {
            int[] arrTemp = Arrays.copyOfRange(arr, 0, middle);
            return find(arrTemp, x);
        }

    }
}
