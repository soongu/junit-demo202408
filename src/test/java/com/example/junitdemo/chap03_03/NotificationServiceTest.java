// src/test/java/com/example/junitdemo/chap03_03/NotificationServiceTest.java

package com.example.junitdemo.chap03_03;

import com.example.junitdemo.chap03_03.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doNothing;

public class NotificationServiceTest {

    @Test
    void testDoNothing() {
        // NotificationService의 목 객체 생성
        NotificationService notificationService = mock(NotificationService.class);

        // doNothing을 사용하여 특정 메서드가 호출되어도 아무 동작도 하지 않도록 설정
        doNothing().when(notificationService).sendNotification();

        // 메서드 호출
        notificationService.sendNotification();

        // 이 메서드 호출은 아무 동작도 하지 않음
        verify(notificationService).sendNotification();  // 호출되었는지만 검증
    }
}
