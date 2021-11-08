package com.homer.basic;

public class ForEachInt {

    public static int[] range(int len){

        int[] result = new int[len];
        for(int i=0; i<len; i++){
            result[i] = i;
        }

        return result;
    }

    public static int[] range(int start, int stop){

        int len = stop - start;
        if(len <= 0){
            System.out.println("错误的参数");
            return null;
        }


        int[] result = new int[len];
        for(int i=0; i<len; i++){
            result[i] = start + i;
        }

        return result;
    }

    public static int[] range(int start, int stop, int step){
        int len = (stop - start)/step + 1;
        if(len <= 0 || step <= 0){
            System.out.println("错误的参数");
            return null;
        }

        int[] result = new int[len];
        for(int i=0,j=start; i<len; i++,j=j+step){
            result[i] = j;
        }

        return result;
    }


    public static void main(String[] args){

//        for (int n:range(10)) {
//            System.out.println(n);
//        }
//
//        for (int n:range(5,10)) {
//            System.out.println(n);
//        }

        for (int n:range(10,20,3)) {
            System.out.println(n);
        }
    }
}
