package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    Optional<User> findUserByEmail(String email);

    //Write a derived query to read a user with an username?
    Optional<User> findUserByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<User> findAllByAccountNameContaining(String username); // since user table has no name field but acount have

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findUsersByAccountNameContainingIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findUsersByAccount_AgeGreaterThan(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserWithEmail(String email);

    //Write a JPQL query that returns a user read by username?
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> fetchUserByUserName(String userName);

    //Write a JPQL query that returns all users?
    @Query("SELECT u FROM User u")
    List<User> fetchAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
//    @Query(value = "SELECT * FROM user_account u JOIN account_details a " +
//            " ON u.account_details_id = a.id " +
//            " WHERE a.name ILIKE CONCAT('%',?1,'%')", nativeQuery = true);
//    List<User> fetchUserByAccountNames(String name);
    //Write a native query that returns all users?
    @Query(value = "SELECT * FROM user_account",nativeQuery = true)
    List<User> fetchAllUser();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "SELECT * FROM user_account u JOIN account_details a ON u.account_details_id = a.id WHERE a.age BETWEEN ?1 and ?2", nativeQuery = true)
    List<User> fetchtAllUsersAgeBetween(Integer age1, Integer age2);

    //Write a native query to read a user by email?
    @Query(value = "SELECT * FROM user_account WHERE email = ?1", nativeQuery = true)
    Optional<User> readUserByEmail(String email);

}
