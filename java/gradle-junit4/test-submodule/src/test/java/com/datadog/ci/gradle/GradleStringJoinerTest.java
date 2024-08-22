package com.datadog.ci.gradle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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