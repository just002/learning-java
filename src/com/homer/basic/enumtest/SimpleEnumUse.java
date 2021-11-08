package com.homer.basic.enumtest;

//import static com.homer.basic.Size.XL;

public class SimpleEnumUse {

    Size size;
    NbSize nbSize;

    SimpleEnumUse(Size size){
        this.size = size;
    }



    void WhosSize(){
        switch (size){
            case XL: System.out.println("Homer's size!");break;
            case M:  System.out.println("Panda's size!");break;
            case XXL:  System.out.println("BigYou's size!");break;
            default: System.out.println("UNKNOWN!");
        }
    }

    public static void main(String[] args) {
//        Size homer = Size.XL;
//        System.out.println(homer);
//
//        Size panda = Size.M;
//        System.out.println(panda);



        SimpleEnumUse a = new SimpleEnumUse(Size.XL);
        SimpleEnumUse b = new SimpleEnumUse(Size.M);
        SimpleEnumUse c = new SimpleEnumUse(Size.XXL);

        a.WhosSize();
        b.WhosSize();
        c.WhosSize();

        for (Size s: Size.values()) {
            System.out.println(s + "   " + s.ordinal());
        }

    }
}
