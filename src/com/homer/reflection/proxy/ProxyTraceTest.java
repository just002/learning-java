package com.homer.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyTraceTest {

    public static void main(String[] args) {

        Object[] numbers = new Object[1000];
        for (int i = 0; i < numbers.length; i++) {

            Integer number = i + 1;
            InvocationHandler traceHandler = new TraceHandler(number);
            Object proxy = Proxy.newProxyInstance(null,new Class[] {Comparable.class}, traceHandler);

            numbers[i] = proxy;
        }

        System.out.println(Arrays.toString(numbers));

        Integer target = (int)(Math.random() * 1000);
        Arrays.binarySearch(numbers, target);
    }
}
