package com.example.springscheduledevelop.controller;

import com.example.springscheduledevelop.dto.ScheduleRequestDto;
import com.example.springscheduledevelop.dto.ScheduleResponseDto;
import com.example.springscheduledevelop.entity.User;
import com.example.springscheduledevelop.service.ScheduleService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto scheduleRequestDto){ //, HttpSession session
       // User loginUser = (User) session.getAttribute("user");

       ScheduleResponseDto scheduleResponseDto =
               scheduleService.save(
                       scheduleRequestDto.getTitle(),
                       scheduleRequestDto.getContent(),
                       scheduleRequestDto.getUsername()
               );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/schedules/all")
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
