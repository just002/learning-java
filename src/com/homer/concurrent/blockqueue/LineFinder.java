package com.homer.concurrent.blockqueue;

import java.util.ArrayList;
import java.util.List;

public class LineFinder {

    private List<Integer> positions = new ArrayList<>();

    private void getIndexFromLine(String keyWord, String line) {
        int index = line.indexOf(keyWord);
        if(index == -1) return;

        //计算真实位置
        if(positions.size() == 0)
            positions.add(index);
        else
            positions.add(index + positions.get(positions.size() - 1) + keyWord.length());


        String next = line.substring(index + keyWord.length());
        if (next.length() > 0)
            getIndexFromLine(keyWord, next);

    }

    public List<Integer> getPositions(String line, String keyWord) {
        getIndexFromLine(keyWord, line);
        return positions;
    }

    public static void main(String[] args) {
        System.out.println(new LineFinder().getPositions("ab ab dddddad   sssab","ab"));
    }
}
