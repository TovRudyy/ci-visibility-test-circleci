package com.datadog.ci.gradle;

public class GradleCalculator {

    public static int add(int a, int b) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(add(2, 2));
    }
}
