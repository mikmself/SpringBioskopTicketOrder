package com.example.springbioskopticketorder.controller;

import com.example.springbioskopticketorder.pojo.ApiResponse;
import com.example.springbioskopticketorder.entity.Booking;
import com.example.springbioskopticketorder.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping("/add")
    public ApiResponse<Booking> addBooking(@RequestBody Booking booking) {
        return service.saveBooking(booking);
    }

    @PostMapping("/adds")
    public ApiResponse<List<Booking>> addBookings(@RequestBody List<Booking> bookings) {
        return service.saveBookings(bookings);
    }

    @GetMapping("/all")
    public ApiResponse<List<Booking>> findAllBookings() {
        return service.getBookings();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<Booking> findBookingById(@PathVariable int id) {
        return service.getBookingById(id);
    }

    @PutMapping("/update")
    public ApiResponse<Booking> updateBooking(@RequestBody Booking booking) {
        return service.updateBooking(booking);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteBooking(@PathVariable int id) {
        return service.deleteBooking(id);
    }
}
