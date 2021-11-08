package com.homer.innerClass;

public class Family {

    class Children {
        String name;
        String age;

        Children(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }


    public void printChildren() {
        Children cd = new Family.Children("zozo");
        //cd.setName("yoyo");
        System.out.println(cd.getName());
    }

    public Children getChildren(String name) {
        return new Children(name);
    }

    public static void main(String[] args) {
        Family f = new Family();
        f.printChildren();

        Family.Children cd = f.getChildren("bobo");
        System.out.println(cd.getName());

    }
}
