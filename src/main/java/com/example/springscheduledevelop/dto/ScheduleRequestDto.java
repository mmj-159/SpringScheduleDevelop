package com.example.springscheduledevelop.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private final String title;
    private final String content;
    private final String username;

    public ScheduleRequestDto(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }
}
