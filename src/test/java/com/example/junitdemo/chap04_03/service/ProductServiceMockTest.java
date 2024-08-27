// src/test/java/com/example/junitdemo/chap04_03/service/ProductServiceMockTest.java
package com.example.junitdemo.chap04_03.service;

import com.example.junitdemo.chap04_03.entity.Product;
import com.example.junitdemo.chap04_03.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = {ProductService.class})
public class ProductServiceMockTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void testGetProductById() {
        Product product = new Product(1L, "Sample Product", 100.0);

        // 모든 메서드를 모킹하여 동작을 지정
        given(productRepository.findById(1L)).willReturn(Optional.of(product));
        given(productRepository.count()).willReturn(10L);

        Optional<Product> foundProduct = productService.getProductById(1L);
        assertEquals("Sample Product", foundProduct.get().name());

        long count = productService.getProductCount();
        assertEquals(10L, count);
    }
}
