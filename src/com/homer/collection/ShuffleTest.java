package com.homer.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class ShuffleTest {

    public static void main(String[] args) {
        List<String>  list = new ArrayList<>();
        for(int i = 60; i < 90; i++) {
            char x = (char)i;
            list.add(new String(new char[]{x}));
        }

        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

        List<String> list1 = list.subList(0,10);
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);

        Properties properties = new Properties();
    }
}
