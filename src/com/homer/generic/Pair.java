package com.homer.generic;

import java.util.Arrays;

/**
 * 用尖括号括起来放在类的后面，表示这是一个泛型类
 * @param <T>
 */
public class Pair<T> {

    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }





}
