package com.example.springbioskopticketorder.controller;

import com.example.springbioskopticketorder.pojo.ApiResponse;
import com.example.springbioskopticketorder.entity.Schedule;
import com.example.springbioskopticketorder.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @PostMapping("/add")
    public ApiResponse<Schedule> addSchedule(@RequestBody Schedule schedule) {
        return service.saveSchedule(schedule);
    }

    @PostMapping("/adds")
    public ApiResponse<List<Schedule>> addSchedules(@RequestBody List<Schedule> schedules) {
        return service.saveSchedules(schedules);
    }

    @GetMapping("")
    public ApiResponse<List<Schedule>> findAllSchedules() {
        return service.getSchedules();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<Schedule> findScheduleById(@PathVariable int id) {
        return service.getScheduleById(id);
    }

    @PutMapping("/update")
    public ApiResponse<Schedule> updateSchedule(@RequestBody Schedule schedule) {
        return service.updateSchedule(schedule);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteSchedule(@PathVariable int id) {
        return service.deleteSchedule(id);
    }
}
