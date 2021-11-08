package com.homer.designPattern.Factory.Fruit;

public class Apple extends Fruit {

    @Override
    public String toString() {
        return (super.isPeeled ? "已削皮的" : "未削皮的") + this.type + "苹果";
    }
}
