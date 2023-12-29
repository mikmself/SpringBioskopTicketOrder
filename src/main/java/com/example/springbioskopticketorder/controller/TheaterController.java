package com.example.springbioskopticketorder.controller;

import com.example.springbioskopticketorder.pojo.ApiResponse;
import com.example.springbioskopticketorder.entity.Theater;
import com.example.springbioskopticketorder.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService service;

    @PostMapping("/add")
    public ApiResponse<Theater> addTheater(@RequestBody Theater theater) {
        return service.saveTheater(theater);
    }

    @PostMapping("/adds")
    public ApiResponse<List<Theater>> addTheaters(@RequestBody List<Theater> theaters) {
        return service.saveTheaters(theaters);
    }

    @GetMapping("")
    public ApiResponse<List<Theater>> findAllTheaters() {
        return service.getTheaters();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<Theater> findTheaterById(@PathVariable int id) {
        return service.getTheaterById(id);
    }

    @PutMapping("/update")
    public ApiResponse<Theater> updateTheater(@RequestBody Theater theater) {
        return service.updateTheater(theater);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteTheater(@PathVariable int id) {
        return service.deleteTheater(id);
    }
}
