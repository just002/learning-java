package com.homer.basic;

public class Book {
    boolean checkedOut = false;

    Book(boolean checkout){
        checkedOut = checkout;
    }

    void checkin(){
        checkedOut = false;
    }

    protected void finalize() {
        if(checkedOut)
            System.out.print("书本未被核查，不得回收！");
        //super.finalize();
    }

    public static void main(String [] args){
        Book a = new Book(true);
        a.checkin();

        new Book(true);
        //new Book(false);

        System.gc();
    }
}
