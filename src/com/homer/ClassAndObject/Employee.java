package com.homer.ClassAndObject;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * 这是类的注释
 * @author Homer
 */
public class Employee extends Person implements Comparable<Employee> {//之前将Employee放在EmployeeTest里面，变成内部类了。。

    /**
     * 属于类的变量，这是其中一种用法
     */
    private static int nextId;

    private int id;
    //private String name;
    private Date hireDay;
    private double salary;
    private String post;

    static {//静态初始化块，属于类，故只会执行一次
        //System.out.println("静态初始化块");
        Random random = new Random();
        nextId = random.nextInt(10000);

        //int ramdom = (int)(Math.random() * 10000);
        //nextId = ramdom ;

        //System.out.println(nextId);
    }

    {//对象初始化块，每次创建对象都会执行
        //System.out.println("对象初始化块");
        this.id = nextId;
        nextId ++;
        //先执行域的初始化，在执行初始化块
        //System.out.println("初始化块name-->" + name);
    }

    public Employee() {};
    public Employee(String name, Date hireDay, double salary) {
        super(name);
        this.hireDay = hireDay;
        this.salary = salary;
    }

    public Employee(String name, Date hireDay, double salary, String post) {
        super(name);
        this.hireDay = hireDay;
        this.salary = salary;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getDescription() {
        return "姓名：" + this.getName() + "\n岗位: " + this.post + "/收入" + this.getSalary();
    }


    public Date getHireDay() {
        //return hireDay; 这样不好，hireDay是一个可变对象，将其引用传出去之后，外部可以修改对象的状态，破坏了封装
        return  (Date) this.hireDay.clone();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", hireDay=" + hireDay +
                ", salary=" + this.getSalary() +
                '}';
    }

    public void releaseSalary(int percent) {
        this.salary = salary + salary * percent/100; //工资提升x%
    }

    public Employee getMe() {
        return this;
    }


    /**
     * IDE生成的equals。需要注意的是，参数应当是Object类型，否则不会覆盖父类的equals()
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.getName(), employee.getName()) && this.getSalary() == employee.getSalary();
    }


    /**
     * 这个是必须的吗？我去掉了equals也能正常运行。
     * 实际上还是调用的Arrays.hashCode()
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSalary());
    }

    /**
     * 实现接口，按照收入进行排序
     * @param other
     * @return
     */
    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.getSalary(), other.getSalary());
    }

//    如果没有使用参数化类型,必须强制转型
//    @Override
//    public int compareTo(Object other) {
//        return Double.compare(this.salary, ((Employee)other).salary);
//    }
}