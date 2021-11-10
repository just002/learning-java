package com.homer.interfaze.HTimer;

import javax.swing.*;
import java.time.LocalDateTime;

public class HTimerTest {

    public static void main(String[] args) {
        //原始做法
        HomerListener listener = new HTimerPrinter();
        HTimer timer = new HTimer(500, listener);
        timer.start(3);

        //lambda
        HTimer timerLambda = new HTimer(500, (int x) -> {System.out.println("lambda实现：" + x + "-->" + LocalDateTime.now());});
        timerLambda.start(3);


        //匿名内部类
        HTimer timerInner = new HTimer(500, new HomerListener() {
            @Override
            public void toDo(int x) {
                System.out.println("匿名内部类实现：" +x + "-->" + LocalDateTime.now());
            }
        });
        timerInner.start(3);

//        try {
//            Thread.sleep(1000 * 3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //进入timer之后，程序根本到不了这里。
        //JOptionPane.showMessageDialog(null, "点击确定后退出。");
        //System.exit(0);
    }
}
