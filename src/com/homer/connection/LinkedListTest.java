package com.homer.connection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {


    public static void main(String[] args) {

        LinkedList<String> marvel = new LinkedList<>();
        marvel.add("Iron Man");
        marvel.add("spider Man");
        marvel.add("Captain America");

        LinkedList<String> DC = new LinkedList<>();
        DC.add("Super Man");
        DC.add("The Flash");
        DC.add("Wonder Woman");

        ListIterator marvelIter = marvel.listIterator();
        Iterator DCIter = DC.iterator();



    }

}
