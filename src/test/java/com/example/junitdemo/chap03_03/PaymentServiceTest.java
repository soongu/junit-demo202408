// src/test/java/com/example/junitdemo/chap03_03/PaymentServiceTest.java

package com.example.junitdemo.chap03_03;

import com.example.junitdemo.chap03_03.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

public class PaymentServiceTest {

    @Test
    void testSpyObject() {
        // PaymentService의 실제 객체 생성
        PaymentService paymentService = new PaymentService();

        // 스파이 객체 생성
        PaymentService spyPaymentService = Mockito.spy(paymentService);

        // 스파이 객체의 특정 메서드만 모킹
        doReturn(40.0).when(spyPaymentService).calculateDiscount();

        // 실제 메서드 호출
        double totalAmount = spyPaymentService.processPayment(100.0);
        assertEquals(60.0, totalAmount);  // 모킹된 메서드의 결과가 반영됨
    }
}
