// src/test/java/com/example/junitdemo/chap03_03/TransactionServiceTest.java

package com.example.junitdemo.chap03_03;

import com.example.junitdemo.chap03_03.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.inOrder;

public class TransactionServiceTest {

    @Test
    void testMethodCallOrder() {
        // TransactionService의 목 객체 생성
        TransactionService transactionService = Mockito.mock(TransactionService.class);

        // 메서드 호출
        transactionService.begin();
        transactionService.commit();
        transactionService.end();

        // InOrder를 사용해 호출 순서 검증
        InOrder inOrder = inOrder(transactionService);
        inOrder.verify(transactionService).begin();
        inOrder.verify(transactionService).commit();
        inOrder.verify(transactionService).end();
    }
}
