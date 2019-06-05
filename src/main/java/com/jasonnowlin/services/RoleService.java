package com.jasonnowlin.services;

import com.jasonnowlin.domain.Movie;
import com.jasonnowlin.domain.Person;
import com.jasonnowlin.domain.Role;
import com.jasonnowlin.repositories.MovieRepository;
import com.jasonnowlin.repositories.PersonRepository;
import com.jasonnowlin.repositories.RoleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final PersonRepository personRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository, PersonRepository personRepository, MovieRepository movieRepository) {
        this.roleRepository = roleRepository;
        this.personRepository = personRepository;
        this.movieRepository = movieRepository;
    }

    public void assign(Long personId, Long movieId) {
        Optional<Person> person = personRepository.findById(personId);
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (person.isPresent() && movie.isPresent()) {
            roleRepository.save(new Role(person.get(), movie.get()));
        }
    }

    public void unassign(Long personId, Long movieId) {
        Optional<Person> person = personRepository.findById(personId);
        Optional<Movie> movie = movieRepository.findById(movieId);

        if (person.isPresent() && movie.isPresent()) {
            Optional<Role> role = roleRepository.findByPersonAndMovie(person.get(), movie.get());
            role.ifPresent(roleRepository::delete);
        }
    }
}
