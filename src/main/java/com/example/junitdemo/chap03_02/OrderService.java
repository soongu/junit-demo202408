package com.example.junitdemo.chap03_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(String itemName) {
        Order order = new Order(null, itemName);
        return orderRepository.save(order);
    }
}
