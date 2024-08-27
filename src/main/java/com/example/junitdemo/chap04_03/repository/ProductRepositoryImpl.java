// src/main/java/com/example/junitdemo/chap04_03/repository/ProductRepositoryImpl.java
package com.example.junitdemo.chap04_03.repository;

import com.example.junitdemo.chap04_03.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<Long, Product> database = new HashMap<>();

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public Product save(Product product) {
        database.put(product.id(), product);
        return product;
    }

    @Override
    public void deleteById(Long id) {
        database.remove(id);
    }

    @Override
    public long count() {
        return database.size();
    }
}
