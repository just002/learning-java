package com.homer.interfaze.HTimer;

import java.time.LocalDateTime;

public class HTimerPrinter implements HomerListener {

    @Override
    public void toDo(int x) {
        System.out.println("接口实现：" + x + "-->" + LocalDateTime.now());
    }

    /**
     * 接口中已有默认实现的方法，同样可以被覆盖。除此之外，与普通方法没有什么其他区别。
     */
    @Override
    public void defaultMethod() {
        System.out.println("覆盖了接口的默认方法。");
    }

    public static void print(int x){
        System.out.println("函数试调用：" + x + "-->" + LocalDateTime.now());
    }
}
