package com.homer.collection.treeSet;

import java.util.Objects;

public class Item implements Comparable<Item>{

    private int partNumber;
    private String description;

    public Item(int partNumber, String description) {
        this.partNumber = partNumber;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "partNumber=" + partNumber +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return partNumber == item.partNumber &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partNumber, description);
    }

    @Override
    public int compareTo(Item o) {
        //return this.partNumber - o.partNumber;

        /**
         * 作者是直接调用integer的比较方法，更为规范。本身我自己对比较的规则就掌握的不好，只是凭借一点点的印象。
         */
        int diff = Integer.compare(this.partNumber, o.partNumber);
        /**
         * 如果编号一样，再以description作为排序
         */
        return diff != 0 ? diff : description.compareTo(o.description);
    }
}
