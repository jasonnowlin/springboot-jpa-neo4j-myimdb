package com.jasonnowlin.controllers;

import com.jasonnowlin.domain.Movie;
import com.jasonnowlin.services.MovieService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieService.create(movie);
    }

    @GetMapping
    public Collection<Movie> find(@RequestParam(value = "title", required = false) String title) {
        return title == null ?
            movieService.findAll() : movieService.findByTitleLike(title);
    }
}
