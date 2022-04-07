package com.homer.concurrent;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private static double[] Accounts;
    private Lock backLock = new ReentrantLock();

    public Bank(int size, double money) {
        Accounts = new double[size];
        Arrays.fill(Accounts, money);
    }

    public double total() {
        //也许不会有Accounts为空的情况？
        if(Accounts == null || Accounts.length == 0)
            return 0;
        double sum = 0;
        for(double x : Accounts)
            sum = sum + x;
        return sum;
    }

    public void transfer(int from, int to, double money) {
        /**
         * 使用锁进行保护之后，不允许多个线程同时访问以下代码。一个线程退出之后解锁，下一次线程才能访问。
         * 数据计算是先从内存中读取变量放入CPU的寄存器，再讲计算完成的变量放回内存。
         * 对于线程来说，原子操作很小，仅仅一个加法运算，就包括读取、计算、存入内存多个步骤（实际上比这么还要多，可以使用javap -c -v Bank命令看字节码，指令是繁多的）
         * 因此，造成错误的原因就，多个线程同时进行计算，会导致一些运算结果被忽略：比如A线程，读取了变量X并运算后，进入睡眠状态；此时B线程进入，同样读取了变量X进行运算，
         * 但B线程没有被中断，完成了所步骤将计算后的变量存入了内存；之后A线程被唤醒，将起对应的计算后的变量存入内存。此时，错误就出现了，B线程的计算结果被忽略！
         *
         */
        backLock.lock();
        try {
            System.out.print(Thread.currentThread());

            if(from == to) {
                System.out.println("转账失败，不能给自己转账");
                return;
            }

            if(Accounts[from] < money) {
                System.out.println("转账失败，Accout[" + from + "]金额不足");
                return;
            }

            Accounts[from] = Accounts[from] - money;
            Accounts[to] = Accounts[to] + money;

            System.out.printf("Account[%d]向Account[%d]转账%10.2f\b",from,to,money);
            System.out.printf("总金额%10.2f \n", this.total());
        }
        finally {
            backLock.unlock();
        }


    }

    public static void main(String[] args) {
        int BANK_SIZE = 10;
        int AMOUNT =1000;
        Bank bank = new Bank(BANK_SIZE,AMOUNT);
        //bank.transfer(1,2,100);

        /**
         * 建了与backsize数目一样的线程，同时允许
         */
        for(int i = 0; i < BANK_SIZE; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Random random = new Random();
                        int from = random.nextInt(BANK_SIZE);
                        int to = random.nextInt(BANK_SIZE);
                        int money = random.nextInt(AMOUNT);
                        bank.transfer(from, to, money);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
