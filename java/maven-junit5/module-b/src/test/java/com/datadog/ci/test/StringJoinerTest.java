package com.datadog.ci.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Disabled
public class StringJoinerTest {

    @Test
    public void join() {
        StringJoiner stringJoiner = new StringJoiner();
        String joined = stringJoiner.join(",", "a", "b", "c");
        assertEquals("a,b,c", joined);
    }

    @Nested
    class NestedSuite {
        @Test
        public void joinWithDash() {
            StringJoiner stringJoiner = new StringJoiner();
            String joined = stringJoiner.join("-", "a", "b", "c");
            assertEquals("a-b-c", joined);
        }
    }
}