package com.homer.interfaze.HTimer;

import javax.swing.*;
import java.time.LocalDateTime;

public class HTimerTest {

    public static void main(String[] args) {

        /**
         * 原始做法：实例化一个接口对象，并传入方法
         */
        HomerListener listener = new HTimerPrinter();
        HTimer timer = new HTimer(500, listener);
        timer.start(3);

        /**
         * 匿名内部类，不再需要单独的HTimerPrinter这个类         *
         */
        HTimer timerInner = new HTimer(500, new HomerListener() {
            @Override
            public void toDo(int x) {
                System.out.println("匿名内部类实现：" +x + "-->" + LocalDateTime.now());
            }
        });
        timerInner.start(3);

        /**
         * lambda，进一步简化，只要关注逻辑实现
         */
        HTimer timerLambda = new HTimer(500, (int x) -> {System.out.println("lambda实现：" + x + "-->" + LocalDateTime.now());});
        timerLambda.start(3);

        listener.defaultMethod();


        /**
         * 还能进一步简化，直接将把println方法作为参数。但是这样就不能像相面集中方式一样，个性化处理参数了（类似于foreach语法）
         * 系统的打印也可以直接调用：new HTimer(500, System.out::println)
         */
        HTimer timerFunction = new HTimer(500, HTimerPrinter::print);
        timerFunction.start(3);

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
