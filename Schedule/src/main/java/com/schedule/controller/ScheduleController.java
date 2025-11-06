package com.schedule.controller;

import com.schedule.dto.*;
import com.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    // 속성
    private final ScheduleService scheduleService;

    // 생성자

    // 기능
    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getSchedule(@PathVariable long scheduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findOne(scheduleId));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponse>> getScheduleList(@RequestParam("scheduleName") String scheduleName) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findAllByName(scheduleName));
    }

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(
            @PathVariable long scheduleId,
            @RequestBody UpdateScheduleRequest request
            )
    {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.update(scheduleId, request));
    }

    @DeleteMapping("/schedules")
    public ResponseEntity<Void> deleteSchedule(
            @RequestBody DeleteScheduleRequest request
    )
    {
        scheduleService.delete(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
