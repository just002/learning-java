package com.homer.basic;

import java.util.Random;

public class ForEachFloat {
    public static void main(String [] args) {
        Random random = new Random(14);
        Float f[] = new Float[10];
        for(int i=0; i<10; i++) {
            f[i] = random.nextFloat();
        }

        for (Float num : f) {
            System.out.println(num);
        }
    }
}
