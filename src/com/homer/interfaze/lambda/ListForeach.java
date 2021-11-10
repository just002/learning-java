package com.homer.interfaze.lambda;

import java.util.ArrayList;
import java.util.List;

public class ListForeach {

    public static void main(String[] args) {
        List<String> dogs = new ArrayList<String>();
        dogs.add("wangcai");
        dogs.add("xiaoqiang");
        dogs.add("dahuang");

        //List提供了一个可以对其元素进行遍历并操作的方法，foreach方法的参数是forEach(Consumer<? super T> action)
        //Consumer属于函数式接口，其实提供了一个可以传入操作方法的入口参数
        dogs.forEach(dog -> {
            System.out.println(dog);
        });
    }
}
