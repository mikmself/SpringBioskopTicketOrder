package com.example.springbioskopticketorder.service;

import com.example.springbioskopticketorder.pojo.ApiResponse;
import com.example.springbioskopticketorder.entity.Film;
import com.example.springbioskopticketorder.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository repository;

    public ApiResponse<Film> saveFilm(Film film) {
        try {
            Film savedFilm = repository.save(film);
            return new ApiResponse<>(HttpStatus.OK.value(), "Film saved successfully", savedFilm);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving film: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Film>> saveFilms(List<Film> films) {
        try {
            List<Film> savedFilms = repository.saveAll(films);
            return new ApiResponse<>(HttpStatus.OK.value(), "Films saved successfully", savedFilms);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error saving films: " + e.getMessage(), null);
        }
    }

    public ApiResponse<List<Film>> getFilms() {
        try {
            List<Film> filmList = repository.findAll();
            return new ApiResponse<>(HttpStatus.OK.value(), "Films retrieved successfully", filmList);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving films: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Film> getFilmById(int id) {
        try {
            Film film = repository.findById(id).orElse(null);
            return new ApiResponse<>(HttpStatus.OK.value(), "Film retrieved successfully", film);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error retrieving film: " + e.getMessage(), null);
        }
    }

    public ApiResponse<String> deleteFilm(int id) {
        try {
            repository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK.value(), "Film removed successfully", "Film removed " + id);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error deleting film: " + e.getMessage(), null);
        }
    }

    public ApiResponse<Film> updateFilm(Film film) {
        try {
            Film existingFilm = repository.findById(film.getId_film()).orElse(null);
            existingFilm.setTitle(film.getTitle());
            existingFilm.setGenre(film.getGenre());
            existingFilm.setDuration(film.getDuration());
            existingFilm.setRelease_year(film.getRelease_year());
            return new ApiResponse<>(HttpStatus.OK.value(), "Film updated successfully", repository.save(existingFilm));
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error updating film: " + e.getMessage(), null);
        }
    }
}
