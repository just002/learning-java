package com.homer.generic;

import com.homer.ClassAndObject.Employee;
import com.homer.ClassAndObject.Student;

import java.util.Date;
import java.util.function.Supplier;

/**
 * 用尖括号括起来放在类的后面，表示这是一个泛型类。
 * 实际上类型擦除之后，T会被翻译成Object
 *
 * @param <T>
 */
public class Pair<T> {

    private T first;
    private T second;

    public Pair() {
    }

    ;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public static <T> Pair<T> makePair(Supplier<T> first, Supplier<T> second) {
        return new Pair<>(first.get(), second.get());

    }

    public static <T> Pair<T> makePair(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return new Pair<>(clazz.newInstance(), clazz.newInstance());

    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Pair<String> pair = Pair.makePair(() -> "Homer", () -> "Panda");
        System.out.println(pair);

        //Employee::new语法只能调用无参数沟通器，如果没有报编译错误。不如直接使用lambda表达式来的痛快
        Pair<Employee> employeePair = Pair.makePair(Employee::new, () -> new Employee("Panda", new Date(), 500));
        System.out.println(employeePair);

        Pair<Student> studentPair = Pair.makePair(Student.class);
        System.out.println(studentPair);
    }
}
