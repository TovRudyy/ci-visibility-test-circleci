package com.datadog.civisibility.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class NumberUtilsTest {

    @Test
    public void testSaturatedCastAboveMax() throws Exception {
        Assert.assertEquals(
                NumberUtils.saturatedCast(1L + Integer.MAX_VALUE),
                Integer.MAX_VALUE
        );
        System.out.println("Finished testSaturatedCastAboveMax in " + Thread.currentThread().getName());
    }

    @Test
    public void testSaturatedCastBelowMin() throws Exception {
        Assert.assertEquals(
                NumberUtils.saturatedCast(-1L + Integer.MIN_VALUE),
                Integer.MIN_VALUE
        );
        System.out.println("Finished testSaturatedCastBelowMin in " + Thread.currentThread().getName());
    }

    @Test
    public void testSaturatedCastWithinRange() throws Exception {
        Assert.assertEquals(
                NumberUtils.saturatedCast(42),
                42
        );
        System.out.println("Finished testSaturatedCastWithinRange in " + Thread.currentThread().getName());
    }

    @AfterClass
    public void tearDownSuite() throws InterruptedException {
        System.out.println("Running tear down suite for " + this + " in " + Thread.currentThread().getName());
        Thread.sleep(500);
    }
}