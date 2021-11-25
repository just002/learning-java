package com.homer.AccessControl;

import static com.homer.basic.Print.*;

public class Range {
    public static int[] range(int n){
        int[] result = new int[n];
        for (int i = 0; i < n; i++){
            result[i] = i;
        }
        return result;
    }

    public static int[] range(int start, int stop){
        int ran = stop - start;
        if(ran < 1){
            print("错误的输入参数！");
            return new int[]{0};
        }

        int[] result = new int[ran];
        for (int i = start; i < ran; i++){
            result[i] = i;
        }
        return result;
    }



    public static void main(String[] args){
        //System.out.println(Range.range(5));
//        for (int i:Range.range(15)) {
//            print(i + " ");
//        }

        for (int i : Range.range(3,100)) {
            print(i + " ");
        }
    }
}
