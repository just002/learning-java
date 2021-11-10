package com.homer.interfaze.HTimer;

import java.time.LocalDateTime;

public class HTimerPrinter implements HomerListener {

    @Override
    public void toDo(int x) {
        System.out.println("接口实现：" + x + "-->" + LocalDateTime.now());
    }
}
