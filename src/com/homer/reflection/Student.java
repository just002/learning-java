package com.homer.reflection;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    private String name;
    private int age;
    private int sex;

    public void readbook(Book book){
        System.out.println(this.name + "读了" + book.getName());
        System.out.println("出版于：" + book.getPublishDate());
        System.out.println("它的作者是" + book.getAuthor());
    }

    public Student() {};

    public Student(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {
        Object a = new Student("王宏",30,1);
        Book b = new Book("Think in Java", LocalDate.of(1996,10,16),"张三丰");

        //虽然将a声明为Object，但系统还是认可他是一个student。
        // 报错：java.lang.ClassCastException: com.homer.reflection.Student cannot be cast to java.util.Date
        ( (Date)a).toString();
    }
}
