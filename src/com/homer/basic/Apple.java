package com.homer.basic;

public class Apple {

    private boolean peeled;
    private boolean washed;

    public Apple(){
        System.out.println("new Apple()");
    }

    public boolean isPeeled() {
        return peeled;
    }

    public Apple getPeeled(){

        return Peeler.peel(this);
    }
    public void setPeeled(boolean peeled) {
        this.peeled = peeled;
    }

    public boolean isWashed() {
        return washed;
    }

    public void setWashed(boolean washed) {
        this.washed = washed;
    }

    public void wash(){
        this.washed = true;
    }

    public void peel(){
        //wash();
        this.wash();
        this.peeled = true;
    }

    void print(){
        System.out.println("Wah?"+this.isWashed());
        System.out.println("Peel?"+this.isPeeled());
    }


    void intubate() {
        System.out.println("prepare patient");
        laryngoscopy();
        this.laryngoscopy();
    }
    void laryngoscopy() {
        System.out.println("use laryngoscope");
    }


    public static void main(String[] args){
//        Apple a = new Apple();
//        a.peel();
//        //a.wash();
//        a.print();


        new Apple().intubate();
    }
}
