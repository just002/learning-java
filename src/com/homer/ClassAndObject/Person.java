package com.homer.ClassAndObject;

import java.util.Date;

public abstract class Person {

    private String name;
    private CommInfo commInfo;
    private String description;

    public Person(){};

    public Person(String name){
        this.name = name;
    }

    public abstract String getDescription();

    public String getName() {
        return this.name;
    }

    public CommInfo getCommInfo() {
        return commInfo;
    }

    public void setCommInfo(CommInfo commInfo) {
        this.commInfo = commInfo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void main(String[] args) {

        Student homer = new Student("王大宏","埃塞俄比亚加里敦大学/",(byte)3,"计算机科学与技术");
        Employee panda = new Employee("熊猫",new Date(),120000.00, "资深软件工程师");
        Manager nb = new Manager("刘备",new Date(),110000.00, 200000, "副主任");

        panda.releaseSalary(10);


        /**
         * 不管转换为什么类型，其实真正引用的对象并没有改变。只是为了能获得转换后对象的方法调用权限！
         */
        Employee nb1 = (Employee)nb;
        Manager nb2 = (Manager)nb1;

        /**
         * 这个操作其实是把这些子类给person代管，真正的对象还是那个对象
         * Person作为他们的父类，可以引用他们，但是被引用对象并没有什么实质性变化。
         * 这个基本类型不一样，基本类型直接相互赋值，对值本身是有影响的。针对对象的引用则不存在这个问题！
         * 需要与类型转换区分一下
         */
        Person[] pers = {homer, panda, nb, nb1, nb2};

        for (Person p : pers) {
            System.out.println(p.getClass() + "-->" + p.getDescription());
            System.out.println("------------------------");
        }
    }

}
