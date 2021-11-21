package com.homer.reflection;

import java.util.Scanner;
import java.lang.reflect.*;

public class ClassPrinter {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("请输入要查看的类（含包路径）");
        //String className = scanner.next();


        //一个带有内部类的类
        String className = "com.homer.interfaze.innerClass.TalkingClock";

        try {
            Class clazz = Class.forName(className);
            Class superClazz = clazz.getSuperclass();

            //打印修饰符
            String modifiers = Modifier.toString(clazz.getModifiers());

            if (modifiers.length()  > 0)
                System.out.print(modifiers + " ");
            //打印类名
            System.out.print(clazz.getName() + " ");

            //打印父类
            if(superClazz != null && superClazz != Object.class)
                System.out.println("extends " + superClazz.getName());

            System.out.println("{");
            //打印构造方法
            printConstructors(clazz);
            System.out.println();
            //打印方法
            printMethods(clazz);
            System.out.println();
            //打印域
            printFields(clazz);
            System.out.println();

            System.out.println("}");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    //getDeclaredConstructors所有构造函数，getConstructors公有的
    private static void printConstructors(Class clazz) {
        Constructor[]  constructor = clazz.getDeclaredConstructors();
        for (Constructor c : constructor) {
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0)
                System.out.print("\t" + modifiers + " ");
            System.out.print(c.getName() + "(");

            Class[] paras = c.getParameterTypes();
            for(int i = 0; i < paras.length; i++) {
                System.out.print(paras[i] + ", ");
                if(i == paras.length - 1)
                    System.out.print(paras[i]);
            }
            System.out.print(");\n");
        }
    }

    private static void printMethods(Class clazz) {

        Method[] methods = clazz.getDeclaredMethods();

        for (Method m : methods) {
            Class retType = m.getReturnType();
            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length() > 0)
                System.out.print("\t" + modifiers + " ");

            System.out.print(retType.getName() + " " +m.getName() + "(");

            Class[] paras = m.getParameterTypes();
            for(int i = 0; i < paras.length; i++) {
                System.out.print(paras[i] + ", ");
                if(i == paras.length - 1)
                    System.out.print(paras[i]);
            }
            System.out.print(");\n");
        }
    }

    private static void printFields(Class clazz) {

        Field[] fields = clazz.getDeclaredFields();

        for(Field f : fields) {
            String modifiers = Modifier.toString(f.getModifiers());
            Class type = f.getType();
            if(modifiers.length() > 0)
                System.out.print("\t" + modifiers + " ");
            System.out.print(type.getName() + " " + f.getName());

            System.out.println(";");
        }

    }


}
