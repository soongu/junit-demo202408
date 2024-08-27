// src/test/java/com/example/junitdemo/chap02_03/BasicAssertionsTest.java
package com.example.junitdemo.chap02_03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BasicAssertionsTest {

    @Test
    void testBasicAssertions() {
        // 두 값이 같은지 확인
        int actual = 2 + 3;
        int expected = 5;
        assertEquals(expected, actual, "2 + 3은 5여야 합니다.");

        // 조건이 참인지 확인
        boolean isPositive = actual > 0;
        assertTrue(isPositive, "결과는 양수여야 합니다.");

        // 조건이 거짓인지 확인
        boolean isNegative = actual < 0;
        assertFalse(isNegative, "결과는 음수가 아니어야 합니다.");

        // 객체가 null인지 확인
        String str = null;
        assertNull(str, "str은 null이어야 합니다.");

        // 객체가 null이 아닌지 확인
        str = "JUnit 5";
        assertNotNull(str, "str은 null이 아니어야 합니다.");
    }
}