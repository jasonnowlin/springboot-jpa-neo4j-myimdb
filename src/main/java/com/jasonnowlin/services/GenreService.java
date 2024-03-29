package com.jasonnowlin.services;

import com.jasonnowlin.domain.Genre;
import com.jasonnowlin.repositories.GenreRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    public Iterable<Genre> findAll() {
        return genreRepository.findAll();
    }

    public Optional<Genre> fetch(Long id) {
        return genreRepository.findById(id);
    }
}
