package com.datadog.ci.gradle;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class GradleCalculatorTest {

    @Test
    public void testAddition() {
        assertEquals(4, GradleCalculator.add(2, 2));
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, GradleCalculator.add(10, -5));
    }

}