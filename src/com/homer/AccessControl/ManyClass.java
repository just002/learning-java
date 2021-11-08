package com.homer.AccessControl;

public class ManyClass {

    public static void main(String[] args) {
        System.out.println(new classb().b);
    }

}



//虽然是写在一个java文件当中，实际上会被编译一个单独class，由于没有权限标识符，这个类只能在它所在的packege包内使用
class classa{
    String a = "123";
}

class classb{
    String b = "456";
}