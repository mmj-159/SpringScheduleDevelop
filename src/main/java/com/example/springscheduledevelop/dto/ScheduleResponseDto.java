package com.example.springscheduledevelop.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long Id;
    private final String author;
    private final String password;
    private final String title;
    private final String content;

    public ScheduleResponseDto( Long Id, String author, String password, String title, String content) {
        this.Id = Id;
        this.author = author;
        this.password = password;
        this.title = title;
        this.content = content;
    }
}
