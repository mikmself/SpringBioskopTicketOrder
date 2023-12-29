package com.example.springbioskopticketorder.controller;

import com.example.springbioskopticketorder.pojo.ApiResponse;
import com.example.springbioskopticketorder.entity.Film;
import com.example.springbioskopticketorder.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService service;

    @PostMapping("/add")
    public ApiResponse<Film> addFilm(@RequestBody Film film) {
        return service.saveFilm(film);
    }

    @PostMapping("/adds")
    public ApiResponse<List<Film>> addFilms(@RequestBody List<Film> films) {
        return service.saveFilms(films);
    }

    @GetMapping("")
    public ApiResponse<List<Film>> findAllFilms() {
        return service.getFilms();
    }

    @GetMapping("/id/{id}")
    public ApiResponse<Film> findFilmById(@PathVariable int id) {
        return service.getFilmById(id);
    }

    @PutMapping("/update")
    public ApiResponse<Film> updateFilm(@RequestBody Film film) {
        return service.updateFilm(film);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<String> deleteFilm(@PathVariable int id) {
        return service.deleteFilm(id);
    }
}
