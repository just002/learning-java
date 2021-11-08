package com.homer.basic.array;

public class CompoundInterest {

    public static void main(String[] args) {

        /*
        这是我看了书上的样例，根据业务自己默写的。
        优化1：以下这几个变量，应该设为final，程序运行后不需要变化
         */
        int years = 10; //纵轴-年
        int interestNum = 6; //横轴-利率（个数）

        //初始化表头-利率
        double interestRate = 10; //增长率

        double[] interest = new double[interestNum];
        for(int i=0; i<interestNum; i++) {
            interest[i] = (i + interestRate) / 100;
        }

        double[][] matrix = new double[years][interestNum];
        //初始化第一行
        for(int i = 0; i < interestNum; i++)
            matrix[0][i] = 10000.00;


        /*
        书上针对for循环的边界判断，都是用的x.length，而不是直接用变量。
        可能是考虑到程序的健壮性
         */
        for(int x = 1; x < years; x++) {
            for(int y = 0; y < interestNum; y++) {
                matrix[x][y] = matrix[x - 1][y] + (matrix[x - 1][y] * interest[y]);

                /*
                我是直接一个公式算结果，虽然结果也对，但是可读性比较差。
                作者是利用两个变量，分别计算上一个值和这次增长的值，再想加。更直观一些

                double old = matrix[x - 1][y];//上一个值
                double increase = old * interest[y];//增长值
                matrix[x][y] = old + increase;
                */

            }
        }

        /*
        printf还没有掌握，需要复习一下
        %9.0f% :f表示浮点数格式，9位字符，保留0个小数
        d% 整数
         */
        for (double x : interest) {
            System.out.printf("%9.0f%%", x * 100);
        }

        System.out.print("\n");

        for (double[] x : matrix) {
            for(double y : x) {
                System.out.printf("%10.2f", y);
            }
            System.out.print("\n");

        }


        System.out.printf("%4d",4);
    }


}
