package com.jasonnowlin.repositories;

import com.jasonnowlin.domain.Movie;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    Collection<Movie> findAll();

    Optional<Movie> findByTitle(@Param("title") String title);

    Collection<Movie> findByTitleLike(@Param("title") String title);

    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(p:Person) RETURN m,r,p;")
    Collection<Movie> graph();
}
