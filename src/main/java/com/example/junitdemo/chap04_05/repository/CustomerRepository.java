// src/main/java/com/example/junitdemo/chap04_05/repository/CustomerRepository.java
package com.example.junitdemo.chap04_05.repository;

import com.example.junitdemo.chap04_05.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmail(String email);
}
