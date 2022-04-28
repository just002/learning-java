package com.homer.concurrent.thread;

import com.homer.ClassAndObject.Employee;

import java.util.Date;

public class ThreadLocalTest {

    private final static ThreadLocal<Employee> tl = new ThreadLocal<>();
    private Date date = new Date();

    public static void printThreadLocalVar() {
        System.out.println("[*" + Thread.currentThread().toString() + "]" + tl.get());
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

        Thread thread3 = new Thread(() -> {
            tl.set(new Employee("xxx", new Date(),5999900));
            Auditor.send();
        });

        /**
         * 为所有线程安全一个处理器，也可以单独给指定线程配置未捕获异常处理器
         */
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println(t + "[统一处理器]发生异常：" + e.getMessage()));
        thread2.setUncaughtExceptionHandler((t, e) -> System.out.println(t + "[单独处理器]发生异常：" + e.getMessage()));
        /**
         * start()会启动一个新线程，而run仍是在main方法的线程中允许，并不是多线程的。
         * 下面线程1和2，启动顺序是1、2，但是实际运行并不是不一定先1后2
         */
        thread1.start();
        thread2.start();
        thread3.start();
    }


    public static ThreadLocal<Employee> getTl() {
        return tl;
    }

    public Date getDate() {
        return date;
    }
}
