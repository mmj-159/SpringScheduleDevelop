package com.example.springscheduledevelop.repository;

import com.example.springscheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
