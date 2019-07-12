package com.example;

public final class MyUtil {

    private MyUtil() {
        throw new AssertionError("This class cannot be instantiated!");
    }

    public static int bitCount(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
