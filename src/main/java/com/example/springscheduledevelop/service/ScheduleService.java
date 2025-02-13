package com.example.springscheduledevelop.service;

import com.example.springscheduledevelop.dto.ScheduleRequestDto;
import com.example.springscheduledevelop.dto.ScheduleResponseDto;
import com.example.springscheduledevelop.entity.Schedule;
import com.example.springscheduledevelop.entity.User;
import com.example.springscheduledevelop.repository.ScheduleRepository;
import com.example.springscheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Transactional
    public ScheduleResponseDto save(String title, String content, String username){
        User findedUser = userRepository.findUserByUsername(username);

        Schedule schedule = new Schedule(title,content);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getId(),savedSchedule.getTitle(),savedSchedule.getContent());
    }

    @Transactional
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(
                    schedule.getId(),
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
                schedule.getTitle(),
                schedule.getContent()
        );
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id에 해당하는 일정 없음")
        );

        schedule.update(dto.getTitle(), dto.getContent());
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent());
    }

    @Transactional
    public void deleteById(Long id) {
       if (!scheduleRepository.existsById(id)){
            throw new IllegalArgumentException("id에 해당하는 일정이 없어서 삭제 할 수 없습니다.");
        }
       scheduleRepository.deleteById(id);
    }
}
