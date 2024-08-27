// src/test/java/com/example/junitdemo/chap04_05/repository/CustomerRepositoryTest.java
package com.example.junitdemo.chap04_05.repository;

import com.example.junitdemo.chap04_05.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveAndFind() {
        // Given
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        customerRepository.save(customer);

        // When
        Optional<Customer> foundCustomer = customerRepository.findById(customer.getId());

        // Then
        assertTrue(foundCustomer.isPresent());
        assertEquals("John Doe", foundCustomer.get().getName());
        assertEquals("john.doe@example.com", foundCustomer.get().getEmail());
    }

    @Test
    public void testFindByEmail() {
        // Given
        Customer customer1 = new Customer("John Doe", "john.doe@example.com");
        Customer customer2 = new Customer("Jane Doe", "jane.doe@example.com");
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        // When
        List<Customer> customers = customerRepository.findByEmail("john.doe@example.com");

        // Then
        assertEquals(1, customers.size());
        assertEquals("John Doe", customers.get(0).getName());
    }

    @Test
    public void testDelete() {
        // Given
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        customerRepository.save(customer);

        // When
        customerRepository.deleteById(customer.getId());
        Optional<Customer> deletedCustomer = customerRepository.findById(customer.getId());

        // Then
        assertFalse(deletedCustomer.isPresent());
    }
}
