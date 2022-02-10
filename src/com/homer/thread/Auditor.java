package com.homer.thread;

import com.homer.ClassAndObject.Employee;

public class Auditor {

    public static void send() {
        ThreadLocal<Employee> tl = ThreadLocalTest.getTl();
        Employee e = tl.get();
        System.out.println(e);
    }
}
