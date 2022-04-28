package com.homer.concurrent;

import java.util.HashMap;
import java.util.Map;

public class LineFinder {

    private String line;
    private Map<String, Integer> positions = new HashMap<>();

    LineFinder(String line) {
        this.line = line;
    }

    private void getIndexFromLine(String keyWord, int start) {
        int index = line.indexOf(keyWord, 0);
        if(index > 0) {
            positions.put(keyWord, index);
            getIndexFromLine(keyWord, index + keyWord.length());
        }
    }

    public static void main(String[] args) {

        String a = "abd 123 ddd   ddd 123 111";
        LineFinder finder = new LineFinder(a);
        //System.out.println(finder.getIndexFromLine("123"););

        System.out.println(a.indexOf("1234"));
        System.out.println(a.indexOf("123", 4 + "123".length()));
    }
}
