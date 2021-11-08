package com.homer.basic;

public class Leaf {

    private int i;
    Leaf(int n){
        this.i = n;
    }

    //返回自己的函数
    Leaf increment(){
        i++;
        return this;
    }

    void print(){
        System.out.println(this.i);
    }

    public static void main(String[] args){
        Leaf l = new Leaf(0);
        //l.increment().increment().increment().increment().print();

        for(int i = 0; i<100; i++){
            l.increment();
        }

        l.print();
    }
}
