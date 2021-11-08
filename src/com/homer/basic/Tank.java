package com.homer.basic;

public class Tank {

    private boolean isFull;
    static {
        Apple a = new Apple();
    }

    Tank(){
        isFull = false;
    }

    void clean(){
        isFull = true;
    }

    protected void finalize(){
        //if(!isFull)
            System.out.println("tank目前状态不为空，不允许回收");
    }

    public static void main(String[] args){
        //new Tank();//或是一开始就未被指定引用

        Tank t = new Tank();
        t = null;//对应引用被清空，程序不可达。对象会被垃圾回收！

        Tank t1 = new Tank();
        System.gc();
    }
}
