package com.homer.interfaze.innerClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.*;

public class TalkingClock {

    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimerPrinter();
        //应用了另一个调用了ActionListener的类型，建立起关联。
        /**
         * 这里老是没有转过弯。总结一下：
         * 1、首先必须要有一个定了一个执行方法的接口-->ActionListener，然后定义一个类型实现该接口方法--> TimerPrinter implements ActionListener。
         * 2、再者，要有一个类使用接口，执行业务。-->Timer.start() 里面实现还蛮复杂，如何来使用ActionListener的逻辑暂时没看懂，但至少他将ActionListener作为参数传进去了。
         * 3、最终，
         */
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    /**
     * 这是一个内部类。直接使用TalkingClock的私有变量
     */
    class TimerPrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("执行时间:" + LocalDateTime.now());
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }

}
