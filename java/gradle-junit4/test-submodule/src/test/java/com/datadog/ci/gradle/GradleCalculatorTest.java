package com.datadog.ci.gradle;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class GradleCalculatorTest {

    private static final Logger LOGGER = LogManager.getLogger(GradleCalculatorTest.class);

    @Test
    public void testAddition() {
        LOGGER.info("Running addition test for {} + {}", 2, 2);
        assertEquals(4, GradleCalculator.add(2, 2));
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, GradleCalculator.add(10, -5));
    }

}