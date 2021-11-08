package com.homer.basic.enumtest;

public enum NbSize {

    /** 一旦有构造函数，就必须按构造函数进行初始化。
     * 由此可以，这么列出来的几个成员其实是NBSize的几个固定实例
     */
    SMALL("S","小号"),MEDIUM("M","中号"),LARGE("L","大号"),EXTRA_LARGE("XL","加大号"),EXTRA_EXTRA_LARGE("XXL","超大号");

    private String flag;
    private String chn;

    //不允许public关键字？
    NbSize(String flag, String chn) {
        //System.out.println("构造函数-->" + flag);
        this.flag = flag;
        this.chn = chn;
    }

    public String getFlag() {
        return flag;
    }

    public String getChn() {
        return chn;
    }

    //    public static NbSize[] XValues() {
//        NbSize[] temp = NbSize.values();
//        for(NbSize i : temp) {
//
//        }
//    }

    public static void main(String[] args) {
        NbSize x = NbSize.EXTRA_LARGE;
        //枚举类的toString是返回枚举值的名称
        System.out.println(x);
        System.out.println(x.getFlag());

        //通过枚举值名称获得Enum实例
        NbSize y = Enum.valueOf(NbSize.class, "SMALL");
        System.out.println(y.toString());

        //values()返回一个成员是Enum各个实例的数组
        NbSize[] values = NbSize.values();

        //ordinal()体现了顺序
        for(NbSize i : values) {
            System.out.println(i.ordinal() + "-->" + i);
        }
    }
}
