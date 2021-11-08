package com.homer.designPattern.Factory.FruitFactory;

import com.homer.designPattern.Factory.Fruit.Watermelon;
import com.homer.designPattern.Factory.Fruit.Fruit;

public class WatermelonFactory implements FruitFactory {


    @Override
    public Fruit create() {
        Watermelon w = new Watermelon();
        w.setType("沙瓤");
        return w;
    }
}
