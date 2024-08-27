// src/test/java/com/example/junitdemo/chap04_02/service/UserServiceIntegrationTest.java
package com.example.junitdemo.chap04_02.service;

import com.example.junitdemo.chap04_02.entity.User;
import com.example.junitdemo.chap04_02.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@SpringBootTest(classes = {UserService.class, UserRepository.class})
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        // Given
        User user = new User();
        user.setId(1L);
        user.setName("홍길동");
        user.setEmail("hong@naver.com");

        given(userRepository.save(user)).willReturn(user);

        // When
        User savedUser = userService.saveUser(user);

        // Then
        assertEquals("홍길동", savedUser.getName());
        assertEquals("hong@naver.com", savedUser.getEmail());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetUserById() {
        // Given
        User user = new User();
        user.setId(1L);
        user.setName("홍길동");
        user.setEmail("hong@naver.com");

        given(userRepository.findById(1L)).willReturn(Optional.of(user));

        // When
        Optional<User> foundUser = userService.getUserById(1L);

        // Then
        assertTrue(foundUser.isPresent());
        assertEquals("홍길동", foundUser.get().getName());
        assertEquals("hong@naver.com", foundUser.get().getEmail());
    }

    @Test
    void testGetAllUsers() {
        // Given
        User user1 = new User();
        user1.setId(1L);
        user1.setName("홍길동");
        user1.setEmail("hong@naver.com");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("이순신");
        user2.setEmail("lee@naver.com");

        given(userRepository.findAll()).willReturn(List.of(user1, user2));

        // When
        List<User> users = userService.getAllUsers();

        // Then
        assertEquals(2, users.size());
        assertEquals("홍길동", users.get(0).getName());
        assertEquals("이순신", users.get(1).getName());
    }

    @Test
    void testDeleteUser() {
        // Given
        Long userId = 1L;

        // When
        userService.deleteUser(userId);

        // Then
        verify(userRepository, times(1)).deleteById(userId);
    }
}