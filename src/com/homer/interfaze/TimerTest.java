package com.homer.interfaze;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.function.Supplier;


public class TimerTest {

    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(1000, listener);
        timer.start();
        //HomerListener listener = new HTimerPrinter();


        /**
         * 如果不想法将系统Hold住，那么系统线程就直接退出了。
         * 作者采用的方法是打卡一个对话框，直到确认后再退出；我自己试了Thread.sleep也是可以的。总之，得手动System.exit(),否则就直接退出达不到效果
         */
        JOptionPane.showMessageDialog(null, "点击确定后退出。");

//        try {
//            Thread.sleep(1000 * 3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.exit(0);

        Runnable R = ()->{};

        Supplier sup = () -> {return 0;};

    }
}
