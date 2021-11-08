package com.homer.basic;

import java.util.Scanner;

public class RetiredYears {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double goal;
        float salary;
        float increase;

        System.out.print("你期望的退休财富是多少：");
        goal = scan.nextDouble();

        System.out.print("你现在年薪资是多少：");
        salary = scan.nextFloat();

        System.out.print("你年薪的年增长率是多少：");
        increase = scan.nextFloat();

        double total = 0.0;
        int year = 0;

        while(total < goal) {

            total += salary;
            total += (salary * increase);

            year++;
        }

        System.out.printf("你需要工作%d年才能退休！", year);

    }
}
