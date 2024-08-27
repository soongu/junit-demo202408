
package com.example.junitdemo.chap03_03;

import com.example.junitdemo.chap03_03.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;

public class UserServiceTest {

    @Test
    void testDoAnswer() {
        // UserService의 목 객체 생성
        UserService userService = Mockito.mock(UserService.class);

        // doAnswer를 사용하여 메서드 호출 시 커스텀 동작을 정의
        doAnswer(invocation -> {
            String name = invocation.getArgument(0);
            return "Hello, " + name + "!";
        }).when(userService).greetUser("John");

        // 메서드 호출 결과 확인
        String result = userService.greetUser("John");
        assertEquals("Hello, John!", result);
    }
}
