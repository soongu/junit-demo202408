// src/test/java/com/example/junitdemo/chap04_03/service/ProductServiceSpyTest.java
package com.example.junitdemo.chap04_03.service;

import com.example.junitdemo.chap04_03.entity.Product;
import com.example.junitdemo.chap04_03.repository.ProductRepository;
import com.example.junitdemo.chap04_03.repository.ProductRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = {ProductService.class})
public class ProductServiceSpyTest {

    @Autowired
    private ProductService productService;

    @SpyBean
    private ProductRepositoryImpl productRepository;  // 실제 구현체를 스파이로 만듦

    @Test
    void testGetProductById() {
        Product product = new Product(1L, "Sample Product", 100.0);

        // 일부 메서드만 모킹
        given(productRepository.findById(1L)).willReturn(Optional.of(product));

        // 스파이된 메서드 동작 확인
        Optional<Product> foundProduct = productService.getProductById(1L);
        assertEquals("Sample Product", foundProduct.get().name());

        // 실제 동작하는 메서드 확인 (실제 카운트가 적용됨)
        Product newProduct = new Product(2L, "New Product", 200.0);
        productService.saveProduct(newProduct);

        long count = productService.getProductCount();
        assertEquals(1L, count); // save 메서드는 실제 동작을 했기 때문에 데이터베이스에 추가됨
    }
}
