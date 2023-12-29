package com.example.springbioskopticketorder.repository;

import com.example.springbioskopticketorder.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
