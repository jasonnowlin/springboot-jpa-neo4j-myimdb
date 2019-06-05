package com.crackedskull.repositories;

import com.crackedskull.domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

}
