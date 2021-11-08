package com.homer.basic.array;

public class Yanghui {

    public static void main(String[] args) {
        final int MAX = 10;//计算杨辉三角的行数

        int[][] yanghui = new int[MAX + 1][];
        for(int i = 0; i < MAX + 1; i++) {
            yanghui[i] = new int[i + 1];
        }

        for(int x = 0; x < yanghui.length; x++){//行
            for(int y = 0; y < yanghui[x].length; y++) {//列
                int panda = 1;//从1开始计算

                /**
                 * 杨辉三角的公式没能理解透彻，此处少写了一个循环。
                 * 其实一共是三个循环，最里面这个循环是用于计算对应格子的值的，这个值是一个循环的乘积：n*(n-1)*(n-2)..(n-k+1)/(1*2*3..k)
                 * 这个公式有时间再研究一下
                 */
                for(int i = 1; i <= y; i++)
                    panda = panda * (x - i + 1) / i;

                yanghui[x][y] = panda;
            }

        }

//        for(int x = 0; x < yanghui.length; x++){//行
//            System.out.println();
//            for(int y = 0; y < yanghui[x].length; y++) {//列
//                System.out.printf("%4d", yanghui[x][y]);
//            }
//
//        }

        for(int[] hang : yanghui) {
            for(int lie : hang) {
                System.out.printf("%4d", lie);
            }
            System.out.println();
        }




    }
}
