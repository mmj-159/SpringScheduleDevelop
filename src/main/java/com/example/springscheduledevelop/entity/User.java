package com.example.springscheduledevelop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long userid;
    private String password;
    private String username;
    private Integer age;

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }
}
