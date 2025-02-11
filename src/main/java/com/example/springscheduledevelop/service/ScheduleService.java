package com.example.springscheduledevelop.service;

import com.example.springscheduledevelop.dto.ScheduleRequestDto;
import com.example.springscheduledevelop.dto.ScheduleResponseDto;
import com.example.springscheduledevelop.entity.Schedule;
import com.example.springscheduledevelop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto scheduleRequestDto){
        Schedule schedule = new Schedule(scheduleRequestDto.getAuthor(), scheduleRequestDto.getPassword(), scheduleRequestDto.getTitle(),scheduleRequestDto.getContent());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getId(),savedSchedule.getAuthor(),savedSchedule.getPassword(),savedSchedule.getTitle(),savedSchedule.getContent());
    }

    @Transactional
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

    @Transactional
    public ScheduleResponseDto findById(Long id){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id에 해당하는 일정 없음")
        );
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getAuthor(),
                schedule.getPassword(),
                schedule.getTitle(),
                schedule.getContent()
        );
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id에 해당하는 일정 없음")
        );

        schedule.update(dto.getAuthor(), dto.getPassword(), dto.getTitle(), dto.getContent());
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getAuthor(),
                schedule.getPassword(),
                schedule.getTitle(),
                schedule.getContent());
    }
}
