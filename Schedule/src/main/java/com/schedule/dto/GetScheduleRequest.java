package com.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetScheduleRequest {
    private String title;
    private String content;
    private String name;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
