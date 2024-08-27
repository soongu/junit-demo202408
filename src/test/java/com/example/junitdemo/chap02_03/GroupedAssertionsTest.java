// src/test/java/com/example/junitdemo/chap02_03/GroupedAssertionsTest.java
package com.example.junitdemo.chap02_03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GroupedAssertionsTest {

    @Test
    void testGroupedAssertions() {
        int number = 5;
        assertAll("숫자에 대한 여러 어설션",
                () -> assertEquals(5, number, "number는 5여야 합니다."),
                () -> assertTrue(number > 0, "number는 양수여야 합니다."),
                () -> assertFalse(number < 0, "number는 음수가 아니어야 합니다.")
        );
    }
}
