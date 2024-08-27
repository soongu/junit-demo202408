// src/main/java/com/example/junitdemo/chap03_03/service/OrderService.java

package com.example.junitdemo.chap03_03.service;

import com.example.junitdemo.chap03_03.exception.OrderNotFoundException;

public class OrderService {

    // 주문 조회 메서드
    public String findOrderById(Long orderId) {
        // 예제에서는 예외를 발생시키기 위해 특정 조건을 사용
        if (orderId == 999L) {
            throw new OrderNotFoundException("Order not found");
        }
        return "Order details for ID: " + orderId;
    }
}
