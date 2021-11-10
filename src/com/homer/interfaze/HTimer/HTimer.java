package com.homer.interfaze.HTimer;

public class HTimer {

    private int interval;
    private HomerListener listener;

    public HTimer(int interval, HomerListener listener) {
        this.interval = interval;
        this.listener = listener;
    }

    /**
     * 这个方式实现有很大问题。由于是单线程，程序运行进来之后就始终在这里循环，外围HTimerTest的其他操作将无法只执行
     */
    public void start(int times) {
        for(int i = 0; i < times; i++) {

            try {
                Thread.sleep(this.interval);
                listener.toDo(i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
