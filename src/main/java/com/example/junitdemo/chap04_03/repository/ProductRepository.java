// src/main/java/com/example/junitdemo/chap04_03/repository/ProductRepository.java
package com.example.junitdemo.chap04_03.repository;

import com.example.junitdemo.chap04_03.entity.Product;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
    long count();
}
