package com.homer.reflection;

import com.homer.ClassAndObject.Employee;
import com.homer.ClassAndObject.Manager;

import java.util.Date;
import java.lang.reflect.Array;

public class ArrayPuller {

    public static Object[] badCopyOf(Object[] other) {
        Object[] newobj = new Object[other.length * 2];
        System.out.println(other.length + "-->" + other.length * 2);
        System.arraycopy(other,0, newobj,0, other.length);
        return newobj;
    }


    /**
     * 我自己写的函数
     * @param other
     * @return
     */
    public static Object[] CopyOf(Object[] other) {
        Class ocl = other.getClass();
        Class type = ocl.getComponentType();
        Object[] newobj = (Object[])Array.newInstance(type, other.length * 2);
        System.arraycopy(other,0, newobj,0, other.length);
        return newobj;
    }

    /**
     * 作者写的
     * @param other
     * @param newLength
     * @return
     */
    public static Object goodCopyOf(Object other, int newLength) {
        Class ocl = other.getClass();
        //作者还考虑了不是数组的情况
        if(!ocl.isArray())
            return null;
        Class type = ocl.getComponentType();
        int length = Array.getLength(other);
        Object newobj = (Object[])Array.newInstance(type, newLength);

        /**
         * 作者使用了Math.min(),使得拷贝的适应性更强。
         * newLength大，则考虑全部成员；newLength小，则拷贝限于newLength这部分成员。
         */
        System.arraycopy(other,0, newobj,0, Math.min(length, newLength));

        return newobj;
    }


    public static void main(String[] args) {
        Employee homer = new Manager("Homer", new Date(), 150000, 100001, "高级软件工程师");
        Employee zhangfei = new Employee("zhangfei", new Date(), 145000);

        Employee[] e = {homer, zhangfei};
        Object[] e1 = ArrayPuller.badCopyOf(e);
        System.out.println(new ObjectAnalyzer().toString(e1));

        /**
         * 使用反射实现的CopyOf()是根据传入的对象类型创建的数组，而不是粗暴地返回Object，因此可以直接转回Employee[]。
         */
        Employee[] e2 = (Employee[])ArrayPuller.CopyOf(e);
        System.out.println(new ObjectAnalyzer().toString(e2));

        Employee[] e3 = (Employee[])ArrayPuller.goodCopyOf(e, 10);
        System.out.println(new ObjectAnalyzer().toString(e3));


    }

}
