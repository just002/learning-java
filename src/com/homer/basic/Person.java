package com.homer.basic;

public class Person {

    public void eat(Apple apple){
        apple.getPeeled();
        System.out.println("我吃了一个苹果：Yummy!" + apple.isPeeled());
    }

    public static void main(String[] args){
        Person person = new Person();
        person.eat(new Apple());
    }
}
