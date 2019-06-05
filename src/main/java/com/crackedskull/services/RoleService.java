package com.crackedskull.services;

import com.crackedskull.domain.Movie;
import com.crackedskull.domain.Person;
import com.crackedskull.domain.Role;
import com.crackedskull.repositories.MovieRepository;
import com.crackedskull.repositories.PersonRepository;
import com.crackedskull.repositories.RoleRepository;
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
