package com.example.springbioskopticketorder.repository;

import com.example.springbioskopticketorder.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
