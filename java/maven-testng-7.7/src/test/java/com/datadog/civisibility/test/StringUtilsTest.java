package com.datadog.civisibility.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringUtilsTest {

    @Test
    public void testToUpperCase() {
        Assert.assertEquals(
                StringUtils.toUpperCase("I love my dog as much as I love you"),
                "I LOVE MY DOG AS MUCH AS I LOVE YOU"
        );
    }

    @Test
    public void testToLowerCase() {
        Assert.assertEquals(
                StringUtils.toLowerCase("But You May Fade, My Dog Will Always Come Through"),
                "but you may fade, my dog will always come through"
        );
    }
}