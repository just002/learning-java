package com.homer.concurrent;

import java.util.Random;

public class BankTest {

    public static void main(String[] args) {

        int BANK_SIZE = 10;
        double AMOUNT =1000;
        //Bank bank = new Bank(BANK_SIZE,AMOUNT);
        SyncBank bank = new SyncBank(BANK_SIZE,AMOUNT);

        /**
         * 建了与backsize数目一样的线程，几个线程循环转账
         */
        for(int i = 0; i < BANK_SIZE; i++) {
            Thread bankTread = new Thread(() -> {
                while (true) {
                    try {
                        Random random = new Random();
                        int from = random.nextInt(BANK_SIZE);
                        int to = random.nextInt(BANK_SIZE);
                        double money = random.nextDouble() * (AMOUNT);
                        if(from == to)
                            continue;
                        bank.transfer(from, to, money);
                        //System.out.println(bank);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            bankTread.start();
        }
    }
}
