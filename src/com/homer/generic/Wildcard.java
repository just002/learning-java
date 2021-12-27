package com.homer.generic;

import com.homer.ClassAndObject.*;
import java.util.Date;

/**
 * 通配符只能修饰变量：方法的参数、域、方法中的变量。
 * 我认为是对泛型的一种特殊用法，一般来说是限定一种类型，通配符的出现可以限定为一个范围（或者不做限定，直接用?）
 */
public class Wildcard {


    /**
     * 这表明Pair<? extends Person>是Pair<Student>、Pair<Employee>的父类，因此凡是Person的子类都可以传入
     * @param pair
     */
    public static void printPair(Pair<? extends Person> pair) {
        if(pair.getFirst() != null)
            System.out.println("First-->" + pair.getFirst());
        if(pair.getSecond() != null)
            System.out.println("Second-->" + pair.getSecond());
    }

    public static void printPairEvery(Pair<?> pair) {
        if(pair.getFirst() != null)
            System.out.println("First-->" + pair.getFirst());
        if(pair.getSecond() != null)
            System.out.println("Second-->" + pair.getSecond());
    }

    public static void main(String[] args) {

        Employee x = new Employee("zhangfei", new Date(), 100);
        Employee y = new Employee("liubei", new Date(), 150000);
        Pair<Employee> pair2 = new Pair<>(x, y);

        Pair<Student> pair3 = new Pair<>();
        pair3.setFirst(new Student("1","1",(byte)3,"1"));

        //Person>Employee>Manager
        //Person>Student

        //不知道是什么类型，但只能是Manager的父类
        //规定了下限，一定是Manager以及其父类，因此给他赋值Manger及其以下的对象都是安全的
        Pair<? super Manager> pair4 = new Pair<>();
        //pair4.setFirst(x);
        //pair4.setFirst(new Student("1","1",(byte)3,"1"));
        pair4.setSecond(new Manager("刘备",new Date(),110000.00, 200000, "副主任"));
        pair4.setSecond(new SeniorManager("刘备",new Date(),110000.00, 200000, "副主任"));

        //不知道是什么类型，但只能是Manager的子类型。
        //规定了上限，类型一定Manager低，一定是Manager的子类，所以说将其赋值给Manager以上的对象都是安全的。
        Pair<? extends Manager> pair5 = new Pair<>();
        //SeniorManager sm = pair5.getFirst(); 这就属于从上往下转了，被认为是不安全的。
        Manager m = pair5.getFirst();
        Employee e = pair5.getFirst();
        Object o = pair5.getFirst();
        //pair5.setFirst(x);
        //pair4.setSecond(new Manager("刘备",new Date(),110000.00, 200000, "副主任"));


        Pair<?> pair6 = new Pair<>();
        Object o1 = pair6.getFirst();
        pair6.setFirst(null);

        printPair(pair2);
        printPair(pair3);
    }

}
