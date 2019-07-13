package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MyUtilTest {

    @ParameterizedTest
    @ValueSource(longs = {-1, 0, 1, 3, 5, -3, 15, Integer.MIN_VALUE, Integer.MAX_VALUE, Long.MIN_VALUE, Long.MAX_VALUE})
    public void testBitCount (long number) {
        Assertions.assertEquals(Long.bitCount(number), MyUtil.bitCount(number), "tested number: " + number);
    }
}
