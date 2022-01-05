package com.homer.generic;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

public class GenericClassPrinter {

    private static void printClass(Class<?> clazz) {

        System.out.print(clazz);

        printTypes(clazz.getTypeParameters(), "<",", ",">",true);
        Type sc = clazz.getGenericSuperclass();

        if(sc != null) {
            System.out.print(" extends ");
            printType(sc, false);
        }

        printTypes(clazz.getGenericInterfaces(), " implements ", ", ", "",false);
        System.out.println();

    }

    private static void printMethod(Method m) {
        System.out.print(Modifier.toString(m.getModifiers()));
        System.out.print(" ");
        printTypes(m.getTypeParameters(), "<", ", ", ">", true);

        printType(m.getGenericReturnType(), false);
        System.out.print(" ");
        System.out.print(m.getName());
        System.out.print("(");
        printTypes(m.getParameterTypes(), "",", ", "",false);
        System.out.print(")");

        System.out.println();
    }

    private static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDef) {
        if(pre.equals(" extends ") && Arrays.equals(types, new Type[]{Object.class}))
            return;

        if(types.length > 0)
            System.out.print(pre);

        for(int i = 0; i < types.length; i++) {
            if(i > 0) System.out.print(sep);
            printType(types[i], isDef);
        }

        if(types.length > 0) System.out.print(suf);
    }

    private static void printType(Type type, boolean isDef) {
        if(type instanceof Class){
            System.out.print(((Class) type).getName());
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String name = "com.homer.generic.Pair";
        Class cl = Class.forName(name);
        printClass(cl);

        for(Method m : cl.getDeclaredMethods())
            printMethod(m);
    }
}
