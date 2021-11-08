package com.homer.designPattern.Factory.FruitFactory;

import com.homer.designPattern.Factory.Fruit.Fruit;
import com.homer.designPattern.Factory.Fruit.Pear;

public class PearFactory  implements FruitFactory  {

    @Override
    public Fruit create() {
        Pear p = new Pear();
        p.setType("雪花");
        return p;
    }

}
