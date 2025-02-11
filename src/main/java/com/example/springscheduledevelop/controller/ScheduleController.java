package com.example.springscheduledevelop.controller;

import com.example.springscheduledevelop.dto.ScheduleRequestDto;
import com.example.springscheduledevelop.dto.ScheduleResponseDto;
import com.example.springscheduledevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto scheduleRequestDto){
        return ResponseEntity.ok(scheduleService.save(scheduleRequestDto));
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> findAll(){
        return scheduleService.findAll();
    }
}
