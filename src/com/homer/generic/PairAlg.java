package com.homer.generic;

public class PairAlg {

    public static boolean hasNull(Pair<?> pair) {
        return pair.getFirst() == null || pair.getSecond() == null;
    }

    /**
     * 为什么要用这个函数包装一层？
     * 原因是swapHelper比如传入指定类型的Pair，但是swap是直接传入
     * @param pair
     */
    public static void swap(Pair<?> pair) {
        swapHelper(pair);
    }

    /**
     * 这样的写法可读性更好
     * @param pair
     * @param <T>
     */
    public static <T> void swapHelper(Pair<T> pair) {
        T first = pair.getFirst();
        T second = pair.getSecond();
        pair.setFirst(second);
        pair.setSecond(first);
    }

    public static void main(String[] args) {
        Pair<String> p = new Pair<>("a",null);
        swap(p);
        System.out.println(p);

        System.out.println(hasNull(p));
    }
}
