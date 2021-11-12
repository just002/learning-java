package com.homer.interfaze;

import com.homer.ClassAndObject.Employee;
import com.homer.ClassAndObject.Student;

import java.util.Arrays;
import java.util.Date;
import java.util.Comparator;

public class ArraySortTest {

    public static void main(String[] args) {
        Employee x = new Employee("zhangfei", new Date(), 145000);
        Employee y = new Employee("liubei", new Date(), 150000);
        Employee z = new Employee("guanyu", new Date(), 146000);
        Employee[] emps = {x, y, z};

        Arrays.stream(emps).forEach((emp)-> System.out.println(emp));

        Arrays.sort(emps);

        Arrays.stream(emps).forEach((emp)-> System.out.println(emp));

        Student homer = new Student("Homer","埃塞俄比亚加里敦大学/",(byte)3,"计算机科学与技术", 10003);
        Student hostman = new Student("hostman","野鸡大学/",(byte)3,"Java",1);
        Student linus = new Student("linus","野鸭大学/",(byte)3,"Linux",25);

        Student[] stus = {homer, hostman, linus};

        /**
         *从第一个参数，推算出了a、b的类型。但是我发现这里并读取a、b的私有域，因此这和直接在Student中实现接口还是有差异。
         * (a, b) -> {return a.getStuNo() - b.getStuNo();} 与a.getStuNo() - b.getStuNo()等价，a.getStuNo() - b.getStuNo()是一个表达式expression
         *
         */
        Arrays.sort(stus, (a, b) -> a.getStuNo() - b.getStuNo());
        //这是IDE建议采用的写法，comparing是Comparator实现的一个静态方法
        Arrays.sort(stus, Comparator.comparing(Student::getStuNo));

        //如果排序方法反过来
        Arrays.sort(stus, (a, b) ->  b.getStuNo() - a.getStuNo());
        Arrays.stream(stus).forEach((stu)-> System.out.println(stu));
    }
}
