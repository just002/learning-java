package com.homer.connection;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue();
        pq.add(LocalDate.of(1986,10,6));
        pq.add(LocalDate.now());
        pq.add(LocalDate.of(2008,11,16));
        pq.add(LocalDate.of(2014,5,14));
        pq.add(LocalDate.of(452,1,1));

        System.out.println("Iterating over elements....");
        for(LocalDate ld : pq) {
            System.out.println(ld);
        }

        System.out.println("removing elements....");
        while (!pq.isEmpty())
            System.out.println(pq.remove());


        ArrayDeque<String> ad = new ArrayDeque<>();
        ad.add("a");
        ad.add("b");
        ad.add("c");//加到队尾
        ad.pop();
        ad.push("f");//往头加元素
        //ad.peek();
        //ad.poll();

        for(String x : ad) {
            System.out.println(ad.peek());
            ad.poll();
        }

    }




}
