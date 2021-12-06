package com.homer.generic;

/**
 * 用尖括号括起来放在类的后面，表示这是一个泛型类。
 * 实际上类型擦除之后，T会被翻译成Object
 * @param <T>
 */
public class Pair<T> {

    private T first;
    private T second;

    public Pair(){};

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

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) throws Exception {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
