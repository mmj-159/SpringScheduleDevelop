package com.example.springscheduledevelop.controller;

import com.example.springscheduledevelop.dto.ScheduleRequestDto;
import com.example.springscheduledevelop.dto.ScheduleResponseDto;
import com.example.springscheduledevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto scheduleRequestDto){
       ScheduleResponseDto scheduleResponseDto =
               scheduleService.save(
                       scheduleRequestDto.getTitle(),
                       scheduleRequestDto.getContent(),
                       scheduleRequestDto.getUsername()
               );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> findAll(){
        return scheduleService.findAll();
    }

    @GetMapping("/schedules/{id}")
    public ScheduleResponseDto findById(@PathVariable Long id){
        return scheduleService.findById(id);
    }

    @PutMapping("/schedules/{id}")
    public ScheduleResponseDto update(@PathVariable Long id, @RequestBody ScheduleRequestDto dto){
        return scheduleService.update(id,dto);
    }

    @DeleteMapping("/schedules/{id}")
    public void deleteById(@PathVariable Long id){
        scheduleService.deleteById(id);
    }
}
