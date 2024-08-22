package com.datadog.ci.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class CalculatorTest {

    @BeforeAll
    public static void setUpClass() throws InterruptedException {
        System.out.println("Setting up " + CalculatorTest.class);
        Thread.sleep(50);
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        System.out.println("Setting up test case " + this);
        Thread.sleep(50);
    }

    @AfterAll
    public static void tearDownClass() throws InterruptedException {
        System.out.println("Tearing down " + CalculatorTest.class);
        Thread.sleep(50);
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        System.out.println("Tearing down test case " + this);
        Thread.sleep(50);
    }

    @Test
    public void testAddition() {
        Calculator c = new Calculator();
        assertEquals(4, c.add(2, 2));
    }

    @Disabled
    @Test
    public void testSubtraction() {
        Calculator c = new Calculator();
        assertEquals(0, c.add(2, -2));
    }

    @Test
    public void testMultiplication() {
        Calculator c = new Calculator();
        assertEquals(9, c.multiply(3, 3));
    }

    @Test
    public void testDivision() {
        Calculator c = new Calculator();
        assertEquals(12, c.divide(36, 3));
    }

    @ParameterizedTest
    @ArgumentsSource(AdditionArguments.class)
    void addParametrized(int a, int b, int c) {
        Calculator calc = new Calculator();
        assertEquals(c, calc.add(a, b));
    }

    static class AdditionArguments implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    arguments(1, 1, 2),
                    arguments(2, 3, 5)
            );
        }
    }

}