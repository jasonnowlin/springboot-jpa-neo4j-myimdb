package com.crackedskull.controllers;

import com.crackedskull.domain.Genre;
import com.crackedskull.services.GenreService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public Genre create(@RequestBody Genre genre) {
        return genreService.create(genre);
    }

    @GetMapping
    public Iterable<Genre> find() {
        return genreService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Genre> fetch(@PathVariable Long id) {
        return genreService.fetch(id);
    }
}
