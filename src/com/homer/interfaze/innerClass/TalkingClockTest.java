package com.homer.interfaze.innerClass;

import javax.swing.*;

public class TalkingClockTest {

    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "点击确定后退出。");

        System.exit(0);
    }
}
