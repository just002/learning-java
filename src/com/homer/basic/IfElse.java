package com.homer.basic;

public class IfElse {
    static int result = 0;

    static void test(int testval, int target){
        if(testval > target)
            result += 1;
        else if(testval < target)
            result -= 1;
        else
            result = 0;
    }

    public static void main(String[] args){
        test(1,0);
        System.out.println(result);

        test(2,0);
        System.out.println(result);

        test(3,0);
        System.out.println(result);
    }
}
