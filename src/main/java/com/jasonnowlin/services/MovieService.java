package com.jasonnowlin.services;

import com.jasonnowlin.domain.Movie;
import com.jasonnowlin.repositories.MovieRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    public Collection<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Collection<Movie> findByTitleLike(String title) {
        return movieRepository.findByTitleLike(title);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
