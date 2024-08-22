package com.datadog.civisibility.test;

public class NumberUtils {

    public static int saturatedCast(long l) {
        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) l;
    }
}
