package com.cydeo.repository;

import com.cydeo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres
    @Query("SELECT g FROM Genre g")
    List<Genre> findAllGenres();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name
    @Query(value = "SELECT * FROM TABLE ( genre ) WHERE name ILIKE CONCAT('%','?1','%') OR sponsor_name ILIKE CONCAT('%','?1','%')", nativeQuery = true)
    List<Genre> findAllByNameContaining(String name);
}
