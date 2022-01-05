package com.homer.connection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {


    public static void main(String[] args) {

        LinkedList<String> MarvelHeros = new LinkedList<>();
        MarvelHeros.add("Iron Man");
        MarvelHeros.add("spider Man");
        MarvelHeros.add("Captain America");

        LinkedList<String> DCHeros = new LinkedList<>();
        DCHeros.add("Super Man");
        DCHeros.add("The Flash");
        DCHeros.add("Wonder Woman");

        //ListIterator具有add方法
        ListIterator marvelIter = MarvelHeros.listIterator();
        Iterator DCIter = DCHeros.iterator();

        while(marvelIter.hasNext()) {
            if (DCIter.hasNext()) {
                marvelIter.next();
            }
            marvelIter.add(DCIter.next());
        }

        System.out.println(MarvelHeros);

        marvelIter = MarvelHeros.listIterator();

        while (marvelIter.hasNext()) {
            marvelIter.next();//直接跳过一个
            //next与remove配合，其实只是删掉下一个，如果不跳过就全部删除掉了。
            if(marvelIter.hasNext()) {
                marvelIter.next();
                marvelIter.remove();
            }
        }

        System.out.println(MarvelHeros);

        DCHeros.removeAll(MarvelHeros);
        System.out.println(DCHeros);
    }

}
