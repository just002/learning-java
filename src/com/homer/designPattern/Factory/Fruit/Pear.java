package com.homer.designPattern.Factory.Fruit;

public class Pear extends Fruit {

    @Override
    public String toString() {
        return (super.isPeeled ? "已削皮的" : "未削皮的") + super.type + "梨子";
    }
}
