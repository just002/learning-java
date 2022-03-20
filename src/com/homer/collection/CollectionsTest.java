package com.homer.collection;

import com.homer.ClassAndObject.Employee;
import com.homer.ClassAndObject.Manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CollectionsTest {

    public static void main(String[] args) {

        Employee liubei = new Manager("liubei", new Date(), 1200,1000);
        Employee guanyu = new Employee("guanyu", new Date(), 1000);
        Employee zhangfei = new Employee("zhangfei", new Date(), 9000);
        Employee xiahouyuan = new Employee("xiahouyuan", new Date(), 1000, "独眼将军");
        Employee caocao = new Manager("caocao", new Date(), 5000,2000);
        Employee simayi = new Manager("simayi", new Date(), 3500,1000);

        List<Employee> list1 = new ArrayList<>();
        list1.add(liubei);
        list1.add(guanyu);
        list1.add(simayi);

        List<Employee> list2 = new ArrayList<>();
        list2.add(liubei);
        list2.add(guanyu);
        list2.add(caocao);
        list2.add(xiahouyuan);

        //list1.removeAll(list2);
        //list1.retainAll(list2);
        //list1.forEach((x) -> System.out.println(x.getName()));

        Employee liubei1 = new Manager("liubei", new Date(), 1200,1000);
        Employee guanyu1 = new Employee("guanyu", new Date(), 1000);
        Employee zhangfei1 = new Employee("zhangfei", new Date(), 9000);
        Employee xiahouyuan1 = new Employee("xiahouyuan", new Date(), 1000, "独眼将军");
        Employee caocao1 = new Manager("caocao", new Date(), 5000,2000);
        Employee simayi1 = new Manager("simayi", new Date(), 3500,1000);

        List<Employee> list3 = new ArrayList<>();
        list3.add(liubei1);
        list3.add(guanyu1);
        list3.add(caocao1);
        list3.add(xiahouyuan1);

        list1.retainAll(list3);
        list1.forEach((x) -> System.out.println(x.getName()));

        /**
         * retainAll以及removeALL是通过成员对象的equals来判断是否为同一对象的。
         * 之所以在实际使用中出问题，是因为一般情况下对象的equals继承的object的，没有重写，必须是同一引用的对象才会被认为是相等。
         * 要使用必须重写equals
         */
    }
}
