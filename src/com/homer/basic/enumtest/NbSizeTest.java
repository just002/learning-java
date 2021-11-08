package com.homer.basic.enumtest;

import java.util.Scanner;

public class NbSizeTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的衣服尺码(S,M,L,XL,XXL)");
        String input = scanner.next();

        NbSize inputSize = null;

        //这样返回的Enum对象包含自定义的域（例子中的flag）
        NbSize[] sizeValues = NbSize.values();
        for(NbSize x : sizeValues){
            //System.out.println(x.getFlag());
            if(input.equalsIgnoreCase(x.getFlag()))
                inputSize = x;
        }

        //NbSize size = Enum.valueOf(NbSize.class, input);

        if(inputSize == null) {
            System.out.println("非法输入：" + inputSize);
            return;
        }
        System.out.println("你的尺码：" + inputSize + "(" + inputSize.getChn() + ")");
        System.out.println("你的尺码缩写：" + inputSize.getFlag());

        //枚举类直接用等号判断是否相等
//        if(NbSize.EXTRA_EXTRA_LARGE == inputSize)
//            System.out.println("兄弟，你该减肥了！");

        switch (inputSize) {
            case SMALL:
                System.out.println("兄弟，你多吃点肉！！");
                break;
            case EXTRA_EXTRA_LARGE:
                System.out.println("兄弟，你该减肥了！");
                break;
            default:
                System.out.println("兄弟，你的身材很标准嘛！");

        }
    }

}
