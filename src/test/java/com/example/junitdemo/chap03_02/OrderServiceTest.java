package com.example.junitdemo.chap03_02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository; // 목 객체 생성

    @InjectMocks
    private OrderService orderService; // 목 객체를 주입한 서비스 클래스

    @Test
    void testPlaceOrder() {
        // 목 객체의 메서드 스터빙: save 메서드가 호출되면 특정 결과 반환
        when(orderRepository.save(any(Order.class)))
                .thenReturn(new Order("123", "에어컨"));

        // 서비스 메서드 호출
        Order order = orderService.placeOrder("에어컨");

        // 결과 검증
        assertEquals("123", order.getId());

        // 메서드 호출 검증: save 메서드가 1번 호출되었는지 확인
        verify(orderRepository, times(1)).save(any(Order.class));

        // 인자 캡처 및 검증
        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);
        verify(orderRepository).save(orderCaptor.capture());
        Order capturedOrder = orderCaptor.getValue();
        assertEquals("에어컨", capturedOrder.getItemName());
    }
}
