package com.schedule.entity;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseTimeEntity {
    // 속성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id값 해쉬로 변경할것
    private Long id;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 50, nullable = false)
    private String content;
    @Column(length = 50, nullable = false)
    private String name;

    // 생성자
    public Schedule(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }

    // 기능

}
