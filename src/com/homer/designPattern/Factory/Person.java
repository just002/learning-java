package com.homer.designPattern.Factory;

import com.homer.designPattern.Factory.FruitFactory.AppleFactory;
import com.homer.designPattern.Factory.FruitFactory.FruitFactory;
import com.homer.designPattern.Factory.FruitFactory.PearFactory;
import com.homer.designPattern.Factory.Fruit.Fruit;
import com.homer.designPattern.Factory.FruitFactory.WatermelonFactory;
import com.homer.designPattern.Factory.cuttingTool.CuttingTool;
import com.homer.designPattern.Factory.cuttingToolFactory.CuttingToolFactory;
import com.homer.designPattern.Factory.cuttingToolFactory.DaggerFactory;

public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(Fruit fruit) {
        System.out.println(this.getName() + "吃" + fruit);
    }

    public void peel(Fruit fruit) {
        fruit.bePeeled();
    }

    public void cut(Fruit fruit, CuttingTool cuttingTool) {
        System.out.println(this.getName() + "用" + cuttingTool + "切开了" + fruit);
        fruit.beCutted();
    }

    public static void main(String[] args) {

        //Fruit app = FruitFactory.create("apple");

        FruitFactory pf = new PearFactory();
        Fruit pear = pf.create();

        Person p = new Person();
        p.setName("奥特曼");

        p.peel(pear);

        p.eat(pear);


        FruitFactory wf = new WatermelonFactory();
        Fruit xg = wf.create();
        CuttingToolFactory ctf = new DaggerFactory();
        CuttingTool ct = ctf.getOne();

        p.cut(xg,ct);
        p.eat(xg);


        FruitFactory af = new AppleFactory();
        Fruit apple = af.create();
        p.peel(apple);
        p.eat(apple);

    }

}
