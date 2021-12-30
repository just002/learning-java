package com.homer.ClassAndObject;

public class Student extends Person {

    private int stuNo;//学号
    private String college;
    private byte grade;
    private String major;

    public Student(){}

    public Student(String name, String college, byte grade, String major){
        super(name);
        this.college = college;
        this.grade = grade;
        this.major = major;
    }

    public Student(String name, String college, byte grade, String major, int stuNo){
        this(name, college, grade, major);
        this.stuNo = stuNo;
    }

    @Override
    public String getDescription() {
        return "姓名：" + this.getName() + "\n大学与专业: " + this.college + this.major + "专业" + this.grade + "年级";
    }

    public int getStuNo() {
        return stuNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", college='" + college + '\'' +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //这里比较奇怪，为何把3赋值给grade就可以，但是作为方法的参数就必须进行强制类型转换呢？
        Student homer = new Student("Homer","埃塞俄比亚加里敦大学/",(byte)3,"计算机科学与技术");
        System.out.println(homer.getDescription());

        byte x = 1;

    }
}
