// src/main/java/com/example/junitdemo/chap03_03/service/PaymentService.java

package com.example.junitdemo.chap03_03.service;

public class PaymentService {

    // 결제 처리 메서드
    public double processPayment(double amount) {
        double discount = calculateDiscount();
        return amount - discount;
    }

    // 할인 계산 메서드
    public double calculateDiscount() {
        // 실제 비즈니스 로직이 있을 수 있음
        return 10.0;
    }
}
