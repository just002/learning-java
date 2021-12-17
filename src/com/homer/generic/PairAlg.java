package com.homer.generic;

public class PairAlg {

    public static boolean hasNull(Pair<?> pair) {
        return pair.getFirst() == null || pair.getSecond() == null;
    }

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
        Pair<String> p = new Pair<>("a","b");
        swap(p);
        System.out.println(p);
    }
}
