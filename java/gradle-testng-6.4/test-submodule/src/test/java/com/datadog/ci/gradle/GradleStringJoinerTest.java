package com.datadog.ci.gradle;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class GradleStringJoinerTest {

    @Test
    public void testJoinHash() {
        assertEquals("1#2#3", GradleStringJoiner.join("#", "1", "2", "3"));
    }

    @Test
    public void testJoinDash() {
        assertEquals("1-2-3", GradleStringJoiner.join("-", "1", "2", "3"));
    }


}