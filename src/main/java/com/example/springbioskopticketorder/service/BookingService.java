package com.example.springbioskopticketorder.service;

import com.example.springbioskopticketorder.pojo.ApiResponse;
import com.example.springbioskopticketorder.entity.Booking;
import com.example.springbioskopticketorder.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    public ApiResponse<Booking> saveBooking(Booking booking) {
        try {
            Booking savedBooking = repository.save(booking);
            return new ApiResponse<>(HttpStatus.OK.value(), "Booking saved successfully", savedBooking);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving booking: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Booking>> saveBookings(List<Booking> bookings) {
        try {
            List<Booking> savedBookings = repository.saveAll(bookings);
            return new ApiResponse<>(HttpStatus.OK.value(), "Bookings saved successfully", savedBookings);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving bookings: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Booking>> getBookings() {
        try {
            List<Booking> bookingList = repository.findAll();
            return new ApiResponse<>(HttpStatus.OK.value(), "Bookings retrieved successfully", bookingList);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving bookings: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Booking> getBookingById(int id) {
        try {
            Booking booking = repository.findById(id).orElse(null);
            return new ApiResponse<>(HttpStatus.OK.value(), "Booking retrieved successfully", booking);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving booking: " + e.getMessage(), null);
        }
    }

    public ApiResponse<String> deleteBooking(int id) {
        try {
            repository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK.value(), "Booking removed successfully", "Booking removed " + id);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error deleting booking: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Booking> updateBooking(Booking booking) {
        try {
            Booking existingBooking = repository.findById(booking.getId_booking()).orElse(null);
            existingBooking.setSchedule_id(booking.getSchedule_id());
            existingBooking.setCustomer_name(booking.getCustomer_name());
            existingBooking.setTicket_quantity(booking.getTicket_quantity());
            return new ApiResponse<>(HttpStatus.OK.value(), "Booking updated successfully", repository.save(existingBooking));
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating booking: " + e.getMessage(), null);
        }
    }
}
