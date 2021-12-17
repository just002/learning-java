package com.homer.generic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 这是示例程序没有彻底看懂，位于书的P327
 */
public abstract class Block {

    public abstract void body() throws Exception;

    public Thread toThread() {
        return new Thread(() -> {
            try {
                body();
            } catch (Throwable e) {
                Block.throwAs(e);
            }
        });
    }

    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable e) throws T {
        throw (T)e;
    }

    public static void main(String[] args) {

        /**
         * 用书中的的方式运行，不需要捕捉Scanner的FileNotFoundException
         */
        new Block() {
            @Override
            public void body() throws Exception {
                Scanner in = new Scanner(new File("README1.md"), "UTF-8");
                while (in.hasNext())
                    System.out.println(in.next());
            }
        }.toThread().start();

        /**
         * 正常写法必须要捕获才能编译通过
         */
        new Runnable() {
            @Override
            public void run() {
                try {
                    Scanner in = new Scanner(new File("README1.md"), "UTF-8");
                    while (in.hasNext())
                        System.out.println(in.next());
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }.run();
    }
}
