package com.homer.basic;

public class Int25 {

    //定义一个成员变量，临时存储上一个数字
    private static int lastNum = (int)(Math.random()*100);
    static boolean flag = true;

    public static void main(String[] args){
//        for(int i = 0; i < 25; i++) {
//            int thisNum = (int)(Math.random()*100);
//            if(lastNum > thisNum)
//                System.out.println(i + "|>：" + lastNum);
//            else if(lastNum < thisNum)
//                System.out.println(i + "|<：" + lastNum);
//            else
//                System.out.println(i + "|=：" + lastNum);
//
//            lastNum = thisNum;
//        }

        while (flag){
            int thisNum = (int)(Math.random()*100);
            if(lastNum > thisNum)
                System.out.print(lastNum + ">");
            else if(lastNum < thisNum)
                System.out.print(lastNum + "<");
            else{
                System.out.print(lastNum + "=");
                flag = false;
            }


            lastNum = thisNum;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
