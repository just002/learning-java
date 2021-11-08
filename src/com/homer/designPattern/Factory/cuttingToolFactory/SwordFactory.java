package com.homer.designPattern.Factory.cuttingToolFactory;

import com.homer.designPattern.Factory.cuttingTool.CuttingTool;
import com.homer.designPattern.Factory.cuttingTool.Sword;

public class SwordFactory implements CuttingToolFactory {

    public CuttingTool getOne() {
        return new Sword();
    }

}
