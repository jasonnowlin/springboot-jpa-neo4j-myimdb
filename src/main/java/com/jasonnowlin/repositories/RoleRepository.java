package com.jasonnowlin.repositories;

import com.jasonnowlin.domain.Movie;
import com.jasonnowlin.domain.Person;
import com.jasonnowlin.domain.Role;
import java.util.Optional;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RoleRepository extends Neo4jRepository<Role, Long> {

    Optional<Role> findByPersonAndMovie(Person person, Movie movie);
}
