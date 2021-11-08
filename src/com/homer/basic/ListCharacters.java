package com.homer.basic;

public class ListCharacters {
    public static void main(String[] args) {
        for(char c = 0; c<128; c++){
            if(Character.isLowerCase(c)){
                System.out.println("大写：" + c + ":" + (int)c);
            }
            if(Character.isUpperCase(c)){
                System.out.println("大写：" + c + ":" + (int)c);
            }
            System.out.println("其他：" +c + ":" + (int)c);
        }
    }
}
