package com.datadog.ci.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
@Tag("outerTag")
public class StringTrimmerTest {

    @BeforeAll
    public static void setUpClass() throws InterruptedException {
        System.out.println("Setting up " + StringTrimmerTest.class);
        Thread.sleep(500);
    }

    @Nested
    @Tag("nestedTag")
    class NestedSuite {
        @Test
        @Tag("testCaseTag")
        public void trim() {
            StringTrimmer stringTrimmer = new StringTrimmer();
            String trimmed = stringTrimmer.trim("   woof   ");
            assertEquals("woof", trimmed);
        }
    }
}
