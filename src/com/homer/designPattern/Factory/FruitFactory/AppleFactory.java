package com.homer.designPattern.Factory.FruitFactory;

import com.homer.designPattern.Factory.Fruit.Apple;
import com.homer.designPattern.Factory.Fruit.Fruit;

public class AppleFactory implements FruitFactory {

    @Override
    public Fruit create() {
        Apple a = new Apple();
        a.setType("红富士");
        return a;
    }

}
