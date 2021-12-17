package com.homer.ClassAndObject;

import java.util.Date;

public class SeniorManager extends Manager {

    private String level;

    public SeniorManager(String name, Date hireDay, double salary, double bonus, String  level) {
        super(name, hireDay, salary, bonus);
        this.level = level;
    }
}
