package com.homer.generic;

import com.homer.ClassAndObject.Employee;
import com.homer.ClassAndObject.Manager;
import com.homer.ClassAndObject.SeniorManager;

import java.util.Date;

public class PairTest2 {

    public static void minMaxBonus(Manager[] m, Pair<? super Manager> pair) {
        //这样写有个很大的问题，程序会继续执行，如果数据不符合应该直接结束。
//        if(m == null || m.length < 1) {
//            pair.setFirst(null);
//            pair.setSecond(null);
//        }

        if(m == null || m.length < 1) return;

        Manager min = m[0];
        Manager max = m[0];
        for (Manager x : m) {
            if(x.getSalary() < min.getSalary()) min = x;
            if(x.getSalary() > max.getSalary()) max = x;
        }

        pair.setFirst(min);
        pair.setSecond(max);
    }

    public static void maxMinBonus(Manager[] m, Pair<? super Manager> pair) {
        minMaxBonus(m, pair);
        PairAlg.swap(pair);
    }

    public static void main(String[] args) {
        SeniorManager ceo = new SeniorManager("刘备",new Date(),50000.00, 20000, "主任");
        Manager cfo = new Manager("张飞",new Date(),50000.00, 5000, "副主任");
        Manager guys = new Manager("费祎",new Date(),10000.00, 3000, "专责");

        Manager[] managers = {ceo, cfo, guys};
        Pair<? super Manager> p = new Pair<>();
        minMaxBonus(managers, p);
        Wildcard.printPairEvery(p);

        maxMinBonus(managers, p);
        Wildcard.printPairEvery(p);

    }
}
