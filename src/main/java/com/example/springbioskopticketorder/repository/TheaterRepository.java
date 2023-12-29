package com.example.springbioskopticketorder.repository;

import com.example.springbioskopticketorder.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
