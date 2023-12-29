package com.example.springbioskopticketorder.repository;

import com.example.springbioskopticketorder.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
