// src/main/java/com/example/junitdemo/chap04_03/service/ProductService.java
package com.example.junitdemo.chap04_03.service;

import com.example.junitdemo.chap04_03.entity.Product;
import com.example.junitdemo.chap04_03.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public long getProductCount() {
        return productRepository.count();
    }
}
