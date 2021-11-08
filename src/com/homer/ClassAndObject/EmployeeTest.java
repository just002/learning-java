package com.homer.ClassAndObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("zhangfei", new Date(), 145000);
        staff[1] = new Manager("liubei", new Date(), 150000, 100000);
        staff[2] = new Employee("guanyu", new Date(), 150000);

        staff[0].releaseSalary(5);

        for(Employee x : staff)
            System.out.println(x);

        Employee x = new Employee("zhangfei", new Date(), 145000);
        Employee y = new Employee("zhangfei", new Date(), 145000);
        Employee z = new Manager("zhangfei", new Date(), 150000, 100000);
        Employee o = new Manager("zhangfei-888", new Date(), 150000, 100001);
        Employee[] staff1 = {x, y, z, o};

        System.out.println(x.equals(y));
        System.out.println(z.equals(o));

        for (Employee i : staff1)
            System.out.println(i.hashCode());


        List<Employee> staffList = new ArrayList<>();
        staffList.add(staff[0]);
        staffList.add(staff[1]);
        staffList.add(staff[2]);
        staffList.add(1,o);

        for(Employee i : staffList)
            System.out.println(i);

//        double x = 1.999999999;
//        int y = (int)x;
//        System.out.println(x  + "-->" + y);
    }


}

