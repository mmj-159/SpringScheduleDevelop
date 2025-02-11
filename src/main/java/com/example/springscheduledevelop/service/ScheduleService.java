package com.example.springscheduledevelop.service;

import com.example.springscheduledevelop.dto.ScheduleRequestDto;
import com.example.springscheduledevelop.dto.ScheduleResponseDto;
import com.example.springscheduledevelop.entity.Schedule;
import com.example.springscheduledevelop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(ScheduleRequestDto scheduleRequestDto){
        Schedule schedule = new Schedule(scheduleRequestDto.getAuthor(), scheduleRequestDto.getPassword(), scheduleRequestDto.getTitle(),scheduleRequestDto.getContent());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getId(),savedSchedule.getAuthor(),savedSchedule.getPassword(),savedSchedule.getTitle(),savedSchedule.getContent());
    }

    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(
                    schedule.getId(),
                    schedule.getAuthor(),
                    schedule.getPassword(),
                    schedule.getTitle(),
                    schedule.getContent()
                    )
            );
        }
        return dtos;
    }
}
