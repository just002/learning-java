package com.homer.interfaze.innerClass;

public interface Selector {

    boolean end();

    /**
     * 索引下移一个位置
     * @return
     */
    void next();

    Object current();
}
