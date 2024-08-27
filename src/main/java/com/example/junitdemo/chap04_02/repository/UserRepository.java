package com.example.junitdemo.chap04_02.repository;

import com.example.junitdemo.chap04_02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
