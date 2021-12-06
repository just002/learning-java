package com.homer.generic;

import com.homer.ClassAndObject.Employee;
import com.homer.ClassAndObject.Person;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Collection;

public class GenericMethod {

    /**
     * 用可变参数要更加一些，因为同时兼容数据和多个参数。而我是直接用的数组。
     * 泛型方法的菱形修饰符位于-->方法的修饰符之后，返回值之前。
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> T getMiddle(T... arr) {
        return arr[arr.length / 2];
    }

    public static <T> void getMiddle1(T... arr) {

    }

    /**
     *
     * @param collection
     * @param ts
     * @param <T>
     */
    @SafeVarargs
    public static <T> void addAll(Collection<T> collection, T... ts) {
        for (T t : ts)
            collection.add(t);
    }

    public static void main(String[] args) {
        System.out.println(GenericMethod.<String>getMiddle(new String[] {"a","b","c","d","e"}));

        //<Integer>通常是被省略的，编译器可以直接推断出。
        double middle = GenericMethod.<Integer>getMiddle(1,2,3,4,5,6,7,8,9,10);
        System.out.println(middle);

        Pair<String> p1 = new Pair<>("a","b");
        Pair<String> p2 = new Pair<>("homer","panda");
        //如果这样初始化数组，是要报错的。但是直接传可变参数又可以。
        //air<String>[] ps = {p1, p2};
        List<Pair<String>> list = new ArrayList<>();
        addAll(list, p1, p2);
        System.out.println(list);


        Dictionary<Integer, Component> dir = new Hashtable<>();
        dir.put(0,new JLabel("1"));
        JSlider js = new JSlider();
        js.setLabelTable(dir);
        @SuppressWarnings("unchecked")
        Dictionary<Integer, Component> dir1 = js.getLabelTable();


        //不能创建参数化类型的数组，以下语句是错误的
        //Pair<Employee>[] a = new Pair<Employee>[1];
        //书上说可以，但是实际测试却不行
        //Pair<String>[] b = (Pair<String>)new Pair<?>[10];
        Pair<Employee> b1 = new Pair<>();

        //替代方式是用List
        List<Pair<Employee>> l = new ArrayList<>();

    }
}
