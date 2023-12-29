package com.example.springbioskopticketorder.service;

import com.example.springbioskopticketorder.pojo.ApiResponse;
import com.example.springbioskopticketorder.entity.Schedule;
import com.example.springbioskopticketorder.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository repository;

    public ApiResponse<Schedule> saveSchedule(Schedule schedule) {
        try {
            Schedule savedSchedule = repository.save(schedule);
            return new ApiResponse<>(HttpStatus.OK.value(), "Schedule saved successfully", savedSchedule);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving schedule: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Schedule>> saveSchedules(List<Schedule> schedules) {
        try {
            List<Schedule> savedSchedules = repository.saveAll(schedules);
            return new ApiResponse<>(HttpStatus.OK.value(), "Schedules saved successfully", savedSchedules);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving schedules: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Schedule>> getSchedules() {
        try {
            List<Schedule> scheduleList = repository.findAll();
            return new ApiResponse<>(HttpStatus.OK.value(), "Schedules retrieved successfully", scheduleList);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving schedules: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Schedule> getScheduleById(int id) {
        try {
            Schedule schedule = repository.findById(id).orElse(null);
            return new ApiResponse<>(HttpStatus.OK.value(), "Schedule retrieved successfully", schedule);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving schedule: " + e.getMessage(), null);
        }
    }

    public ApiResponse<String> deleteSchedule(int id) {
        try {
            repository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK.value(), "Schedule removed successfully", "Schedule removed " + id);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error deleting schedule: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Schedule> updateSchedule(Schedule schedule) {
        try {
            Schedule existingSchedule = repository.findById(schedule.getId_schedule()).orElse(null);
            existingSchedule.setFilm_id(schedule.getFilm_id());
            existingSchedule.setTheater_id(schedule.getTheater_id());
            existingSchedule.setDate(schedule.getDate());
            existingSchedule.setTime(schedule.getTime());
            return new ApiResponse<>(HttpStatus.OK.value(), "Schedule updated successfully", repository.save(existingSchedule));
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating schedule: " + e.getMessage(), null);
        }
    }
}
