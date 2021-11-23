package com.homer.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyTraceTest {

    public static void main(String[] args) {

        Object[] numbers = new Object[1000];
        for (int i = 0; i < numbers.length; i++) {

            Integer number = i + 1;
            /**
             * 其本质是用Proxy.newProxyInstance()方法创建了代理对象，然后调用者其实是用的代理对象来实现业务，这对调用者是透明的。
             * Proxy.newProxyInstance()需要传入三个参数。
             * 1、ClassLoader，保持默认的类加载器，传入null即可。
             * 2、Class[]要监测或处理的接口事件对应的一组接口。
             * 3、InvocationHandler。在InvocationHandler中就可以添加要实现的业务逻辑（本实例中是实现跟踪，就打印了一些调用信息）。
             */
            InvocationHandler traceHandler = new TraceHandler(number);
            Object proxy = Proxy.newProxyInstance(null,new Class[] {Comparable.class}, traceHandler);
            numbers[i] = proxy;
        }

        System.out.println(Arrays.toString(numbers));

        Integer target = (int)(Math.random() * 1000);
        Arrays.binarySearch(numbers, target);
    }
}
