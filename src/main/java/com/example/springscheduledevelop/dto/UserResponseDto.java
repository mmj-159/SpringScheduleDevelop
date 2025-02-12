package com.example.springscheduledevelop.dto;

import com.example.springscheduledevelop.entity.Schedule;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private final Long id;
    private final String username;
    private final String email;

    public UserResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
