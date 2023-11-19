package com.cydeo.repository;

import com.cydeo.entity.Movie;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Optional<Movie> readByName(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> readAllByPriceBetween(BigDecimal min, BigDecimal max);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> getAllByDurationIn(List<Integer> durationList);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> getAllByReleaseDateAfter(LocalDate date);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateIsAndTypeIs(String state, String type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("SELECT m FROM Movie m WHERE m.price BETWEEN ?1 AND ?2")
    List<Movie> getMovieByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    //Write a JPQL query that returns all movie names
    @Query("SELECT m.name FROM Movie m")
    List<String> getAllMovieNames();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name

    //Write a native query that return the list of movies in a specific range of prices

    //Write a native query to return all movies where duration exists in the range of duration

    //Write a native query to list the top 5 most expensive movies

}
