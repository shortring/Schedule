package com.schedule.service;

import com.schedule.dto.CreateScheduleRequest;
import com.schedule.dto.CreateScheduleResponse;
import com.schedule.entity.Schedule;
import com.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@Getter
@RequiredArgsConstructor
public class ScheduleService {
    // 속성
    private final ScheduleRepository scheduleRepository;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

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
}