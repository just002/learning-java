package com.homer.concurrent.thread;

import com.homer.ClassAndObject.Employee;

public class Auditor {

    public static void send() {
        ThreadLocal<Employee> tl = ThreadLocalTest.getTl();
        Employee e = tl.get();
        //int x = 1/0;
        System.out.println("[" + Thread.currentThread().toString() + "]" + e);
        System.out.println(new ThreadLocalTest().getDate());

    }
}
