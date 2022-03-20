package com.homer.collection.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Item a = new Item(100, "cpu");
        Item b = new Item(80, "mem");
        Item c = new Item(50, "disk");
        Item e = new Item(50, "abc");
        Item f = new Item(50, "zzz");

        TreeSet<Item> treeSet = new TreeSet<>();
        treeSet.add(a);
        treeSet.add(b);
        treeSet.add(c);
        treeSet.add(e);
        treeSet.add(f);

        System.out.println(treeSet);

        //直接使用自定义的比较器，而不是item的比较器
        TreeSet<Item> treeSet1 = new TreeSet<>(Comparator.comparing(Item::getDescription));
        treeSet1.addAll(treeSet);
        System.out.println(treeSet1);

    }


}
