package com.homer.ClassAndObject;

import java.util.Date;
import java.util.Objects;

public class Manager extends Employee {

    private double bonus = 0d;

    public Manager(String name, Date hireDay, double salary, double bonus){
        super(name, hireDay, salary);
        this.bonus = bonus;
    }

    public Manager(String name, Date hireDay, double salary, double bonus, String post){
        super(name, hireDay, salary, post);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return this.bonus;
    }

    @Override
    public boolean equals(Object anotherObject) {
        if(!super.equals(anotherObject))
            return false;

        Manager manager = (Manager)anotherObject;

        /**
         * 作者是直接反馈this.bonus == manager.getBonus()，要更简洁一些
         */
//        if(this.bonus == manager.getBonus())
//            return true;
//
//        return false;

        return this.bonus == manager.getBonus();
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 17 * new Double(this.bonus).hashCode();
    }

}
