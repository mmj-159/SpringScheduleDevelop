package com.example.springscheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "user")
@Getter
@Entity
@NoArgsConstructor

public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    public User(String username,String password,  String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }
}
