package com.homer.basic;

import java.util.Random;

public class VowelsAndConsonants {

    public static void main(String[] args){
        Random random = new Random(47);

        for(int i = 0; i<100; i++){
            int ch = random.nextInt(26) + 'a';
            System.out.print((char)ch + " " + ch);
            switch (ch){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': System.out.println("这是元音字母"); break;
                default: System.out.println("这是一般字母"); break;

            }
        }


//
//        for(int i=0;i<10;i++){
//            //System.out.println("****" + i);
//            switch (i){
//                case 0: System.out.println("0");
//                case 1: System.out.println("1");
//                case 2: System.out.println("2");break;
//                case 3: System.out.println("3");break;
//                default: System.out.println("Other");
//            }
//        }
    }

}
