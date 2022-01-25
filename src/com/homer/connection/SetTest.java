package com.homer.connection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetTest {

    public static void main(String[] args)  {
        HashSet words = new HashSet();
        long time = 0;

        //jdk1.7之后，该语法用于关于资源连接，防止连接泄露
        try(Scanner scanner = new Scanner(new File("C:\\Users\\Homer\\Desktop\\11-0.txt"))) {
            while (scanner.hasNext()) {
                long start = System.currentTimeMillis();
                words.add(scanner.next());
                time += (System.currentTimeMillis() - start);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Iterator it = words.iterator();
        for(int i = 0; i <=20 && it.hasNext(); i++) {
            System.out.print(" " + it.next());
        }

        System.out.println("单词个数：" + words.size() + "\n花费时间(ms)：" +  time);

    }
}
