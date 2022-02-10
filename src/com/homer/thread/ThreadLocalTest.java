package com.homer.thread;

import com.homer.ClassAndObject.Employee;

import java.util.Date;

public class ThreadLocalTest {

    public final static ThreadLocal<Employee> tl = new ThreadLocal<>();

    public static void printThreadLocalVar() {
        System.out.println("ThreadLocal-->" + tl.get());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            tl.set(new Employee("Homer", new Date(),1000));
            printThreadLocalVar();
        });

        Thread thread2 = new Thread(() -> {
            tl.set(new Employee("Panda", new Date(),500));
            Auditor.send();
        });


        thread1.run();

        thread2.run();
    }


    public static ThreadLocal<Employee> getTl() {
        return tl;
    }
}
