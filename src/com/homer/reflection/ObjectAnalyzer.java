package com.homer.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import com.homer.ClassAndObject.CommInfo;
import com.homer.ClassAndObject.Employee;
import com.homer.ClassAndObject.Manager;
import com.homer.ClassAndObject.Person;

public class ObjectAnalyzer {

    /**
     * 一开始我竟然将visited放到方法中……完全没有意义。
     * 但是放到这之后，就必须new来调用了，不是太方便
     */
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj) {

        if(obj == null)
            return "null";

        Class clazz = obj.getClass();

        //这两个类比较特殊，如果不加String Date还会继续深入，打印出一些不需要了解的信息。
        //但是查了这两个类，上级都是Object,其原因不明
        if(String.class == clazz || java.time.LocalDate.class == clazz)
            return obj.toString();

        if(Date.class == clazz) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(obj);
        }

        /**
         * 作者的程序加入记录已访问过的对象，但是不清楚具体何用
         * 后台测试发现，的确存在，比如java.time.LocalDate。这个很有必要，你并不清楚遇到什么类就又遇到这种情况！
         * 作为补充，加入对LocalDate、Date等类的特殊处理（if(String.class == clazz || java.time.LocalDate.class == clazz)）
         * 因为循环打印出来的东西没有意义。
         */
        if(this.visited.contains(obj))
            return "...";
        this.visited.add(obj);


        //如果是数组要单独考虑
        if(clazz.isArray()) {
            //获取元素类型
            String r = clazz.getComponentType().getName() + "[]{";
            int length = Array.getLength(obj);
            for(int i = 0; i < length ; i++) {
                //元素值
                Object val = Array.get(obj, i);

                if(!clazz.getComponentType().isPrimitive())
                    val = toString(val);

                if(i == length - 1)
                    r += val;
                else
                    r += val + ", ";
            }
            return r + "}";
        }

        /**
         * 他的基本原理，就是从当前的对象开始，一直往上级追溯每一个域，直到该域是可打印的八大基本类型为止。
         */
        //一般对象
        String r = "";
        do{
            r += clazz.getName();
            Field[] fields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(fields,  true);
            r = r + "[";
            for (int i = 0; i < fields.length; i++)  {

                if(!Modifier.isStatic(fields[i].getModifiers()) && !Modifier.isFinal(fields[i].getModifiers())) {
                //if(true) {
                    try {
                        Object value = fields[i].get(obj);

                        String valStr;
                        Class type = fields[i].getType();
                        if(type.isPrimitive()) {
                            valStr = value + "";
                        }
                        else {
                            valStr = toString(value);//如果不是基本类型，循环调用
                        }

                        //System.out.println("-->" + f.getName() + "=" + valStr);

                        if(i == fields.length - 1)
                            r += (fields[i].getName() + "=" + valStr);
                        else
                            r += (fields[i].getName() + "=" + valStr + ", ");

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    //System.out.println("f.getType()-->" + f.getType() + "-->" +  t1.isPrimitive());

                    //System.out.println("------------------------");

                }

            }
            r += "]";

            clazz = clazz.getSuperclass();

        } while (clazz != Object.class);


        return r;
        //return "我是非数组";
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        String[] arr2 = {"1","2","3"};

        Book a = new Book("Think in Java", LocalDate.of(1996,10,16),"张三丰");
        Book b = new Book("Core Java",LocalDate.of(2006,10,16),"Hostman");
        Student s  = new Student("Homer",30,1);
        Employee o = new Manager("Homer", new Date(), 150000, 100001, "高级软件工程师");
        Employee y = new Employee("zhangfei", new Date(), 145000);


        CommInfo commInfo = new CommInfo("龙虎山一号","13923456262");
        o.setCommInfo(commInfo);


        Book[] books = {a, b};

        ArrayList<Person> pl = new  ArrayList<Person>();
        pl.add(o);
        pl.add(y);

        //System.out.println(ObjectAnalyzer.toString(arr1));
        //System.out.println(ObjectAnalyzer.toString(arr2));
        System.out.println(new ObjectAnalyzer().toString(pl));
        //System.out.println(Arrays.toString(arr));


//        Date d = new Date();
//        String s1 = " ";
//        Class clazz = s1.getClass();
//        do{
//            System.out.println(clazz.getName());
//            clazz = clazz.getSuperclass();
//        }
//        //while (!(Object.class == clazz));
//        while (null != clazz);

    }


}
