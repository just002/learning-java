package com.homer.designPattern.Factory.cuttingToolFactory;


import com.homer.designPattern.Factory.cuttingTool.CuttingTool;
import com.homer.designPattern.Factory.cuttingTool.Dagger;

public class DaggerFactory implements CuttingToolFactory {

    public CuttingTool getOne() {
        return new Dagger();
    }
}
