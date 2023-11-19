package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countAllByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByMovieId(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeAfter(LocalDateTime dateTime);

    //Write a derived query to find the top 3 expensive movies
    List<Movie> getTop3ByOrderByMovie_PriceDesc();

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovie_NameContainingIgnoreCase(String movieName);

    //Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema> getAllByCinema_Location_Name(String name);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("SELECT m FROM MovieCinema m WHERE m.dateTime > ?1")
    List<MovieCinema> getAllBySortedBy(LocalDate date);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "SELECT COUNT(*) FROM TABLE ( movie_cinema ) GROUP BY cinema_id",nativeQuery = true)
    Integer countMovieCinemaById();

    //Write a native query that returns all movie cinemas by location name
    @Query(value = "SELECT * FROM movie_cinema mc JOIN cinema c ON mc.cinema_id = c.id " +
            "JOIN location l ON location_id=l.id " +
            "WHERE l.name = ?1",nativeQuery = true)
    List<MovieCinema> getAllByCinema_Location();

}
