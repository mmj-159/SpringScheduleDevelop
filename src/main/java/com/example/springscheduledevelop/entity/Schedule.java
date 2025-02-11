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
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long scheduleId;
    private String content;

    public Schedule(String content) {
        this.content = content;
    }

    public void update(String content) {
        this.content = content;
    }
}
