package com.pluralsight.SakilaSpringDemo.controllers;

import com.pluralsight.SakilaSpringDemo.models.Film;
import com.pluralsight.SakilaSpringDemo.dao.FilmDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FilmController {

    @Autowired
    @Qualifier("jdbcFilmDao")
    private FilmDao filmDao;

    // get all films
    @GetMapping("/api/films")
    public List<Film> getFilms() {
        return filmDao.getAll();
    }

    // find film by id
    @GetMapping("/api/films/id")
    public Film getFilmsById(@PathVariable int id) {
        return filmDao.findById(id);
    }

    // post mapping
    @PostMapping("/api/films")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Film addFilm(@RequestBody Film film) {
        return filmDao.add(film);
    }

//     put mapping
//    @PutMapping("/api/films/{id}")
//    @ResponseStatus(value = HttpStatus.OK)
//    public void updateFilm(@PathVariable int id, @RequestBody Film film) {
//        filmDao.updateFilm(id, film);
//    }

    // delete mapping
//    @DeleteMapping("/api/films/{id}")
//    @ResponseStatus(value = HttpStatus.OK)
//    public void deleteFilm(@PathVariable int id) {
//        filmDao.deleteFilm(id);
//    }

    @GetMapping("/")
    public String defaultRequest() {
        return "Hello World!";
    }

    // another way to make the value different
//    @GetMapping("/")
//    public String defaultRequest(@RequestParam(defaultValue="World") String name) {
//        return "Hello " + name;
//    }

}
