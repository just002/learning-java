package com.homer.reflection;

import java.util.Date;
import java.time.LocalDate;
import com.homer.reflection.entity.*;

public class Read {

    public static  void main(String[] args){

        Book b = new Book("Core Java",LocalDate.of(1996,10,16),"Hostman");
        Student s  = new Student("Homer",30,1);

        //s.readbook(b);


        Class bookClass = null;
        Class<Student> studentClass = null;

        try {
            /**
             * 获取Class的三种方式
             * clazz = Class.forName("com.homer.reflection.entity.Book");
             * clazz = Book.class;
             * clazz = b.getClass();
             */
            bookClass = Class.forName("com.homer.reflection.entity.Book");
            studentClass = Student.class;
            //newInstance()调用无参数构造器，如果没有报java.lang.InstantiationException
            Book book = (Book) bookClass.newInstance();
            //如果参数化的定义Class变量-->Class<Student>，则不需要转型
            Student student = studentClass.newInstance();
            student.readbook(book);

            //通过调用Constructor的newInstance()可以指定某个构造器。
            Book book1 = (Book) bookClass.getConstructor(String.class, LocalDate.class, String.class).newInstance("Core Java",LocalDate.of(1996,10,16),"Hostman");
            Student student1 = studentClass.getConstructor(String.class, int.class, int.class).newInstance("Homer",30,1);
            student1.readbook(book1);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        //System.out.println(clazz);


    }




}
