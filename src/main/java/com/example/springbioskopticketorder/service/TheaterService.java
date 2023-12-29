package com.example.springbioskopticketorder.service;

import com.example.springbioskopticketorder.pojo.ApiResponse;
import com.example.springbioskopticketorder.entity.Theater;
import com.example.springbioskopticketorder.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository repository;

    public ApiResponse<Theater> saveTheater(Theater theater) {
        try {
            Theater savedTheater = repository.save(theater);
            return new ApiResponse<>(HttpStatus.OK.value(), "Theater saved successfully", savedTheater);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving theater: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Theater>> saveTheaters(List<Theater> theaters) {
        try {
            List<Theater> savedTheaters = repository.saveAll(theaters);
            return new ApiResponse<>(HttpStatus.OK.value(), "Theaters saved successfully", savedTheaters);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving theaters: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Theater>> getTheaters() {
        try {
            List<Theater> theaterList = repository.findAll();
            return new ApiResponse<>(HttpStatus.OK.value(), "Theaters retrieved successfully", theaterList);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving theaters: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Theater> getTheaterById(int id) {
        try {
            Theater theater = repository.findById(id).orElse(null);
            return new ApiResponse<>(HttpStatus.OK.value(), "Theater retrieved successfully", theater);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving theater: " + e.getMessage(), null);
        }
    }

    public ApiResponse<String> deleteTheater(int id) {
        try {
            repository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK.value(), "Theater removed successfully", "Theater removed " + id);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error deleting theater: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Theater> updateTheater(Theater theater) {
        try {
            Theater existingTheater = repository.findById(theater.getId_theater()).orElse(null);
            existingTheater.setTheater_name(theater.getTheater_name());
            existingTheater.setCapacity(theater.getCapacity());
            return new ApiResponse<>(HttpStatus.OK.value(), "Theater updated successfully", repository.save(existingTheater));
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating theater: " + e.getMessage(), null);
        }
    }
}
