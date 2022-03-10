package com.homer.connection;

import com.homer.ClassAndObject.Employee;
import com.homer.ClassAndObject.Manager;

import java.util.Date;
import java.util.HashMap;

public class MapTest {

    public static void main(String[] args) {

        HashMap<String, Employee> emps = new HashMap<>();
        Employee liubei = new Employee("liubei", new Date(), 145000);
        Employee guanyu = new Employee("guanyu", new Date(), 145000);
        Employee zhangfei = new Manager("", new Date(), 150000, 100000);
        Employee xiahouyuan = new Manager("xiahouyuan", new Date(), 150000, 100001);

        emps.put("liubei",liubei);
        emps.put("guanyu",guanyu);
        emps.put("zhangfei",zhangfei);
        emps.put("xiahouyuan",xiahouyuan);

        emps.forEach((x,y) -> {
            if ("liubei".equals(x))
                System.out.println("我是" + y);
        });


    }
}
