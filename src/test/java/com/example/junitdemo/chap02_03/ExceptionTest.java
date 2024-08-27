// src/test/java/com/example/junitdemo/chap02_03/ExceptionTest.java
package com.example.junitdemo.chap02_03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {

    @Test
    void testException() {
        // IllegalArgumentException이 발생하는지 테스트
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("잘못된 인자");
        });

        // 발생한 예외의 메시지가 예상대로인지 확인
        String expectedMessage = "잘못된 인자";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage, "예외 메시지가 일치해야 합니다.");
    }
}
