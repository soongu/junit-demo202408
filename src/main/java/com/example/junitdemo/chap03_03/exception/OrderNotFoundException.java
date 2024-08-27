// src/main/java/com/example/junitdemo/chap03_03/exception/OrderNotFoundException.java

package com.example.junitdemo.chap03_03.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message) {
        super(message);
    }
}
