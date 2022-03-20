package com.homer.collection;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\project\\learning-java\\src\\com\\homer\\collection\\homer.properties"));
        } catch (IOException e) {
            System.err.println("读取配置文件发生异常！");
        }

        properties.setProperty("homer.word","Programmer");
        properties.setProperty("homer.wife","panda");

        properties.forEach((k,v) -> System.out.println(k + "->"+ v));

        try {
            OutputStream out = new FileOutputStream("D:\\project\\learning-java\\src\\com\\homer\\collection\\homer1.properties");
            properties.store(out, "This is Homer's test properties.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
