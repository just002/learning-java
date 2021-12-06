package com.homer.generic;

import java.time.LocalDate;

public class DataInterval extends Pair<LocalDate> {

    @Override
    public void setSecond(LocalDate second) throws Exception {
        if(this.getFirst() != null && second.compareTo(this.getFirst()) <= 0) {
            super.setSecond(this.getFirst());
            super.setFirst(second);
        } else {
            super.setSecond(second);
        }
    }

    public static void main(String[] args) throws Exception {
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.now().plusDays(1);

        DataInterval di = new DataInterval();
        //di.setFirst(ld2);
        di.setSecond(ld1);
        di.setFirst(ld2);

        System.out.println(di);
    }

}
