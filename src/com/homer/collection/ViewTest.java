package com.homer.collection;

import java.util.*;

public class ViewTest {
    public static void main(String[] args) {

        String[] a = {"a","b","c"};
        List<String> list = Arrays.asList(a);//list实际上是Arrays的内部类，并不是java.util.ArrayList
        list.set(1,"xxxxx");
        list.forEach(System.out::println);

        /**
         * 表面上没有报错，但是系统并不允许对list执行编辑操作。java.lang.UnsupportedOperationException
         */
        //list.add("b");
        //list.remove(0);

        List<String> nCopie = Collections.nCopies(5, "old");
        //nCopie.set(1,"new"); 此视图也不能进行set
        for(int i = 0; i < nCopie.size(); i++) {
            System.out.println(i + "->" + nCopie.get(i));
        }
        System.out.println(nCopie);

        Set<String> single  = Collections.singleton("haha");
        System.out.println(single);


    }
}
