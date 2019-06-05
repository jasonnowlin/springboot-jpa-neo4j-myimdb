package com.crackedskull.repositories;

import com.crackedskull.domain.Movie;
import com.crackedskull.domain.Person;
import com.crackedskull.domain.Role;
import java.util.Optional;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RoleRepository extends Neo4jRepository<Role, Long> {

    Optional<Role> findByPersonAndMovie(Person person, Movie movie);
}
