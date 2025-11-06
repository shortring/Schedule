package com.schedule.service;

import com.schedule.dto.*;
import com.schedule.entity.Schedule;
import com.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@RequiredArgsConstructor
public class ScheduleService {
    // 속성
    private final ScheduleRepository scheduleRepository;

    // 생성자

    // 기능
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getName(),
                request.getPassword()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getName(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    @Transactional
    public GetScheduleResponse findOne(long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );
        return new GetScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public List<GetScheduleResponse> findAllByName(String name) {
        List<Schedule> scheduleList;
        if(name.isEmpty()) {
            scheduleList = scheduleRepository.findAll();
        }else {
            scheduleList = scheduleRepository.findAllByName(name);
        }
        List<GetScheduleResponse> dtoList = new ArrayList<>();

        for (Schedule schedule : scheduleList) {
            GetScheduleResponse dto = new GetScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getName(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Transactional
    public UpdateScheduleResponse update(long scheduleId, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        if(request.getPassword().equals(schedule.getPassword())) {
            schedule.updateSchedule(request.getTitle(), request.getName());
        } else {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }

        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getName(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public void delete(DeleteScheduleRequest request) {
        System.out.println("start delete");
        Schedule schedule = scheduleRepository.findById(request.getId()).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        if(schedule.getPassword().equals(request.getPassword())) {
            scheduleRepository.deleteById(request.getId());
        } else {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
    }
}