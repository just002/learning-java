package com.homer.basic;

import java.util.Scanner;
import java.io.Console;

public class PrimeNumber {

    private static int no = 1;

    public static void main(String [] args) {
        for(int number = 0; number < 10000; number++) {
            for(int j = 2; j < number; j++) {
                if(number % j == 0) {//只要发现有一个数字被整除，说明不是质数
                    //System.out.println(number + "X");
                    break;
                }
                if(number - 1 == j){//如果已经计算到了上一个数都没有被整除，说明是质数
                    System.out.println(no++ + ":"+ number);
                    break;
                }

            }


        }


//        String test = "123";
//        System.out.println(test == "123");
//
//        System.out.println(test.substring(0,2) == "12");

//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        int a = scanner.nextInt();
//        System.out.println(name+a);


//        Console con = System.console();//在IDE中调不出来，需要直接cmd运行
//        String name = con.readLine("12345-->");
//        System.out.println(name);

//        String name="Homer";
//        String name1="panda";
//        int age = 35;
//        System.out.printf("%s's %s age is %d",name1,name,age);

//        double t = -10000000.0/3.0;
//        System.out.printf("%,.2f", t);

//        System.out.println(System.getProperty("user.dir"));
//
//        for(int i = 10; i >= 0; i--)
//            System.out.println(i);

    }
}
