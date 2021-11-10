package com.homer.interfaze.innerClass;

public class Sequence {
    private Object[] items;
    private int index;

    public Sequence(int size) {
        items = new Object[size];
        index = 0;//默认也是0
    }

    public void add(Object o) {
        if(index < items.length)
            items[index++] = o;
    }

    /**
     * 迭代器
     */
    private class SequenceSelector implements Selector {
        private  int i = 0;//迭代器de索引值

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public void next() {
            if(i < items.length)
                i++;
        }

        @Override
        public Object current() {
            return items[i];//直接访问外部类的私有成员域
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence s = new Sequence(5);
        for(int i=0; i<5; i++) {
            s.add(i);
        }

        Selector slor = s.selector();
        while (!slor.end()) {
            System.out.println(slor.current());
            slor.next();
        }


    }
}
