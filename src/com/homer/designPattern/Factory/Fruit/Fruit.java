package com.homer.designPattern.Factory.Fruit;

public class Fruit {

    protected String type;

    protected boolean isPeeled = false;

    protected boolean isCutted = false;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void bePeeled() {
        this.isPeeled = true;
    }

    public void beCutted() {
        this.isCutted = true;
    }

}
