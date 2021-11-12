package com.homer.interfaze.HTimer;

/**
 * 标记为函数式接口：只有一个接口方法的接口，并且这个方法不能是有默认实现。
 */
@FunctionalInterface
public interface HomerListener {

    default void defaultMethod() {
        System.out.println("接口的默认方法可以引用接口的类实现。");
    }

    void toDo(int x);

}
