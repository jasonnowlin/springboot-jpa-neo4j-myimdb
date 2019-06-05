package com.crackedskull.repositories;

import com.crackedskull.domain.Genre;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface GenreRepository extends Neo4jRepository<Genre, Long> {

}
