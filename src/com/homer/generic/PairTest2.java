package com.homer.generic;

import com.homer.ClassAndObject.Employee;
import com.homer.ClassAndObject.Manager;
import com.homer.ClassAndObject.SeniorManager;

import java.util.Date;

public class PairTest2 {
    public static void main(String[] args) throws Exception {
        SeniorManager ceo = new SeniorManager("刘备",new Date(),50000.00, 200000, "主任");
        Manager cfo = new Manager("张飞",new Date(),10000.00, 50, "副主任");
        Employee guys = new Employee("zhangfei", new Date(), 1000000);


        Employee[] emps = {ceo, cfo, guys};

        Pair<Employee> maxmin = PairTest.getMaxMin(emps);

        Wildcard.printPair(maxmin);

        PairAlg.swap(maxmin);

        Wildcard.printPair(maxmin);

    }
}
