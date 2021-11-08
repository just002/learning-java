package com.homer.designPattern.Factory.Fruit;

public class Watermelon extends Fruit {

    @Override
    public String toString() {
        return (super.isCutted ? "切好的" : "未切开的") + super.type + "西瓜";
    }
}
