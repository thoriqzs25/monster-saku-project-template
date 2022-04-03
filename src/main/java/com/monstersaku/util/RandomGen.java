package com.monstersaku.util;

import java.util.Random;

public class RandomGen {
    private static int upperBound;

    public static void random(int n) {
        upperBound = n;
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            System.out.println(rand.nextInt(n) + 1);
        }
    }
}
