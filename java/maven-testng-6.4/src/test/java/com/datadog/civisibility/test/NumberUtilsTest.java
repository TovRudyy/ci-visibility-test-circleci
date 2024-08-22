package com.datadog.civisibility.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NumberUtilsTest {

    @BeforeClass
    public static void setUpSuite() {
        System.out.println("Running suite set up");
    }

    @AfterClass
    public static void tearDownSuite() {
        System.out.println("Running suite tear down");
    }

    @Test
    public void testSaturatedCastAboveMax() {
        Assert.assertEquals(
                NumberUtils.saturatedCast(1L + Integer.MAX_VALUE),
                Integer.MAX_VALUE
        );
    }

    @Test
    public void testSaturatedCastBelowMin() {
        Assert.assertEquals(
                NumberUtils.saturatedCast(-1L + Integer.MIN_VALUE),
                Integer.MIN_VALUE
        );
    }

    @Test
    public void testSaturatedCastWithinRange() {
        Assert.assertEquals(
                NumberUtils.saturatedCast(42),
                42
        );
    }
}