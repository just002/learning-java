package com.homer.concurrent;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncBank {

    private static double[] Accounts;

    public SyncBank(int size, double money) {
        Accounts = new double[size];
        Arrays.fill(Accounts, money);
    }

    public synchronized double total() {
        //也许不会有Accounts为空的情况？
        if(Accounts == null || Accounts.length == 0)
            return 0;
        double sum = 0;
        for(double x : Accounts)
            sum = sum + x;
        return sum;
    }

    public synchronized void transfer(int from, int to, double money) throws InterruptedException {

        System.out.print(Thread.currentThread());
        while (Accounts[from] < money) {
            wait();
            System.out.println("Account[" + from + "]金额不足，线程等待");
        }

        if (from == to) {
            System.out.println("转账失败，不能给自己转账");
            return;
        }
        Accounts[from] = Accounts[from] - money;
        Accounts[to] = Accounts[to] + money;
        System.out.printf("Account[%d]向Account[%d]转账%10.2f\b", from, to, money);
        System.out.printf("总金额%10.2f \n", this.total());

        notifyAll();
    }

    @Override
    public String toString() {
        return Arrays.toString(Accounts);
    }
}
