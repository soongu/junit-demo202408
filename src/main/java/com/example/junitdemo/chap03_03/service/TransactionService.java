// src/main/java/com/example/junitdemo/chap03_03/service/TransactionService.java

package com.example.junitdemo.chap03_03.service;

public class TransactionService {

    // 트랜잭션 시작 메서드
    public void begin() {
        System.out.println("Transaction Begin");
    }

    // 트랜잭션 커밋 메서드
    public void commit() {
        System.out.println("Transaction Commit");
    }

    // 트랜잭션 종료 메서드
    public void end() {
        System.out.println("Transaction End");
    }
}
