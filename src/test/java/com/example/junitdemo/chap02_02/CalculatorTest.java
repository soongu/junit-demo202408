// src/test/java/com/example/junitdemo/chap02_02/CalculatorTest.java
package com.example.junitdemo.chap02_02;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    static Calculator calculator;

    @BeforeAll
    static void setUpBeforeClass() {
        // 모든 테스트 전에 한 번 실행되는 메서드
        System.out.println("Setting up before all tests");
        calculator = new Calculator();
    }

    @AfterAll
    static void tearDownAfterClass() {
        // 모든 테스트 후에 한 번 실행되는 메서드
        System.out.println("Tearing down after all tests");
        calculator = null;
    }

    @BeforeEach
    void setUp() {
        // 각 테스트 메서드 실행 전에 실행되는 메서드
        System.out.println("Setting up before a test");
    }

    @AfterEach
    void tearDown() {
        // 각 테스트 메서드 실행 후에 실행되는 메서드
        System.out.println("Tearing down after a test");
    }

    @Test
    @DisplayName("Test addition of two numbers")
    void testAddition() {
        System.out.println("Running testAddition");
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Test subtraction of two numbers")
    void testSubtraction() {
        System.out.println("Running testSubtraction");
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Test multiplication of two numbers")
    void testMultiplication() {
        System.out.println("Running testMultiplication");
        int result = calculator.multiply(4, 2);
        assertEquals(8, result);
    }

    @Test
    @DisplayName("Test division of two numbers")
    void testDivision() {
        System.out.println("Running testDivision");
        int result = calculator.divide(6, 2);
        assertEquals(3, result);
    }

    @Test
    @Disabled("This test is disabled until the division by zero issue is fixed")
    @DisplayName("Test division by zero (disabled)")
    void testDivisionByZero() {
        System.out.println("Running testDivisionByZero");
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0));
    }
}
