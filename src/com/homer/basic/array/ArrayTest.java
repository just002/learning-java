package com.homer.basic.array;

import java.util.Arrays;

public class ArrayTest {

    ArrayTest() {
        System.out.println("ArrayTest() ");
    }

    ArrayTest(String str) {
        System.out.println("ArrayTest(String str) " + str);
    }

    static void func(String... str){
        System.out.println(str.length + Arrays.toString(str));
    }

    public static void main(String[] args) {

        //数组的几种创建方式，方括号可以位于变量后方，也可位于元素类型的后方。
        int a[];
        int[] b;//这种方式也许更好，Thinking in Java认为如此

        //初始化方式，最后一个元素后面的逗号写不写都没问题
        int[] c = {0,1,2,3,};

        int[] d = new int[4];
        d[0] = 0;
        d[1] = 1;

        //装箱就是自动将基本数据类型转换为包装器类型；拆箱就是自动将包装器类型转换为基本数据类型。
        Integer[] e = new Integer[]{new Integer(0),1,2,3};

        ArrayTest[] at0 = new ArrayTest[2];
        ArrayTest[] at1 = {new ArrayTest("1"),new ArrayTest()};


        func(new String[]{"1","2"});
        func("a","b","b","b","b","b");


        int[] f = new int[5];
        Arrays.fill(f,10000);

        for (int i : f)
            System.out.println(i);
    }

}
