package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {



//    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought id
//    Integer countAllByUserAccountId(Long id);

    //Write a derived query to list all tickets by specific email
//    List<Ticket> getAllByUserAccount_Email(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countTicketsByMovieCinema_Movie_Name(String name);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> getTicketsByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
//    @Query("SELECT t FROM Ticket t JOIN User u ON t.userAccount = u.account WHERE t.userAccount.email =?1")
//    List<Ticket> getTicketsByUserAccount_Email(String email);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> getTicketsByDateBetween(LocalDateTime date1, LocalDateTime date2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
//    @Query(value = "SELECT count(*) FROM ticket t WHERE user_account_id =?1", nativeQuery = true)
//    Integer countTicketsByUserAccountEmail(Long id);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT COUNT(*) FROM ticket WHERE user_account_id = ?1 AND date_time BETWEEN ?2 AND ?3", nativeQuery = true)
    Integer countUserTicketsByDateBetween(Long UserId, LocalDateTime date1, LocalDateTime date2);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT DISTINCT (*) FROM ticket T JOIN movie_cinema mc on mc.id = T.movie_cinema_id JOIN movie m on m.id = mc.movie_id WHERE m.name = ?1", nativeQuery = true)
    List<Ticket> getDistinctByMovieName(String name);

    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua on ua.id = t.user_account_id WHERE email = ?1", nativeQuery = true)
    List<Ticket> getAllByUserEmail(String email);

    //Write a native query that returns all tickets
    @Query(value = "SELECT * FROM ticket", nativeQuery = true)
    List<Ticket> getAll();

    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name
    @Query(value = "SELECT * FROM ticket t union " +
            "JOIN user_account ua on ua.id = t.user_account_id WHERE ua.username ILIKE CONCAT('%',?1,'%')" +
            "JOIN account_details ad on ad.id = ua.account_details_id WHERE ad.name ILIKE CONCAT('%',?1,'%') " +
            "JOIN movie_cinema mc on mc.id = t.movie_cinema_id " +
            "JOIN movie m on m.id = mc.movie_id " +
            "WHERE m.name ILIKE CONCAT('%',?1,'%') OR ", nativeQuery = true)
    List<Ticket> retrieveAllBySearchCriteria(String pattern);

}
