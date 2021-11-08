package com.homer.reflection;

import java.util.Date;
import java.time.LocalDate;

public class hello {

    public static  void main(String[] args){
        //System.out.println("hello");

        Book b = new Book("Think in Java",LocalDate.of(1996,10,16),"张三丰");
        Student s  = new Student("王宏",30,1);

        //s.readbook(b);


        Class bookClass = null;
        Class<Student> studentClass = null;

        try {
            /**
             * 获取Class的三种方式
             * clazz = Class.forName("com.homer.reflection.Book");
             * clazz = Book.class;
             * clazz = b.getClass();
             */
            bookClass = Class.forName("com.homer.reflection.Book");
            studentClass = Student.class;
            //newInstance()调用无参数构造器，如果没有报java.lang.InstantiationException
            Book book = (Book) bookClass.newInstance();
            //如果参数化的定义Class变量-->Class<Student>，则不需要转型
            Student student = studentClass.newInstance();

            student.readbook(book);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //System.out.println(clazz);


    }




}
