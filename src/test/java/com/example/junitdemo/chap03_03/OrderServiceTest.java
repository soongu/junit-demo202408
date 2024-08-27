// src/test/java/com/example/junitdemo/chap03_03/OrderServiceTest.java

package com.example.junitdemo.chap03_03;

import com.example.junitdemo.chap03_03.service.OrderService;
import com.example.junitdemo.chap03_03.exception.OrderNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Test
    void testDoThrow() {
        // OrderService의 목 객체 생성
        OrderService orderService = mock(OrderService.class);

        // 특정 메서드 호출 시 예외를 던지도록 설정
        doThrow(new OrderNotFoundException("Order not found"))
                .when(orderService)
                .findOrderById(999L);

        // 예외 발생을 확인
        assertThrows(OrderNotFoundException.class, () -> {
            orderService.findOrderById(999L);
        });
    }
}
