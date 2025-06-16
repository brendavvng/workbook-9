package com.pluralsight.SakilaSpringDemo.controllers;

import com.pluralsight.SakilaSpringDemo.models.Film;
import com.pluralsight.SakilaSpringDemo.dao.FilmDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FilmController {

    @Autowired
    @Qualifier("jdbcFilmDao")
    private FilmDao filmDao;

    @GetMapping("/api/films")
    public List<Film> getFilms() {
        return filmDao.getAll();
    }

}
