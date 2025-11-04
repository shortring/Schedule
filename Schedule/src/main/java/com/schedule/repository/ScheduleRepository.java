package com.schedule.repository;

import com.schedule.entity.Schedule;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
