package com.homer.collection;

import com.homer.ClassAndObject.Employee;
import com.homer.ClassAndObject.Manager;
import java.util.*;

public class MapTest {

    public static void main(String[] args) {

        Employee liubei = new Manager("liubei", new Date(), 1200,1000);
        Employee guanyu = new Employee("guanyu", new Date(), 1000);
        Employee zhangfei = new Employee("zhangfei", new Date(), 9000);
        Employee xiahouyuan = new Employee("xiahouyuan", new Date(), 1000, "独眼将军");
        Employee caocao = new Manager("caocao", new Date(), 5000,2000);
        Employee simayi = new Manager("simayi", new Date(), 3500,1000);


        HashMap<String, Employee> emps = new HashMap<>();
        emps.put("guanyu",guanyu);
        emps.put("xiahouyuan",xiahouyuan);
        emps.put("liubei",liubei);
        emps.put("zhangfei",zhangfei);
        emps.put("caocao", caocao);

//        emps.forEach((x, y) ->
//                System.out.println(x + "-->" + y)
//        );

        /**
         * 只能用key进行比较，不能用value。如果不传入比较器，默认采用key对象的构造器
         */
        TreeMap<Employee, String> sortedEmps = new TreeMap<>();
        TreeMap<Employee, String> sortedEmps1 = new TreeMap<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.getName().compareTo(b.getName());
            }
        });
        sortedEmps.put(guanyu, "guanyu");
        sortedEmps.put(xiahouyuan, "xiahouyuan");
        sortedEmps.put(liubei, "liubei");
        sortedEmps.put(zhangfei, "zhangfei");
        sortedEmps.put(caocao, "caocao");
        sortedEmps.put(simayi, "simayi");
//        sortedEmps.forEach((x,y) -> {
//            System.out.println(x +"-->"+ y + "/" + x.getSalary());
//        });
//        System.out.println(sortedEmps.firstKey());
//        System.out.println(sortedEmps.lastKey());

        /**
         * 默认按照写入顺序输出
         */
        //Map<String, Employee> linkedEmps = new LinkedHashMap<>();
        /**
         * 自定义写入顺序还是get顺序，同时可以自定义一个删除条件，按使用频率高低进行排序
         */
        Map<String, Employee> linkedEmps = new LinkedHashMap<String, Employee>(5, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Employee> eldest) {
                System.out.println("-->" + size());
                return size() > 4;
            }
        };
        linkedEmps.put("simayi", simayi);
        linkedEmps.put("guanyu", guanyu);
        linkedEmps.put("xiahouyuan", xiahouyuan);
        linkedEmps.put("liubei", liubei);
        linkedEmps.put("zhangfei", zhangfei);
        linkedEmps.put("caocao", caocao);

        //linkedEmps.put("guanyu", guanyu);
        //linkedEmps.put("caocao", caocao);

       // System.out.println(linkedEmps.get("liubei"));
        System.out.println(linkedEmps.get("xiahouyuan"));


        linkedEmps.forEach((x, y) -> System.out.println(x + "-->" + y));


        //System.out.println(linkedEmps);

    }
}
