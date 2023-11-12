package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.rmi.dgc.Lease;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findAllByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findAllByAgeLessThanEqual(int age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findAllByUserRole(UserRole userRole);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findAllByAgeBetween(int min, int max);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findAllByAddressStartingWith(String pattern);

    //Write a derived query to sort the list of accounts with age
    List<Account> findAllByOrderByAgeDesc();

    // ------------------- JPQL QUERIES ------------------- //
    // the biggest difference between the derive and and native queries with JPQL queries
    // JPQL queries works fine if migrate into any other databasd provider
    // use @Query("") method name doesn't matter
    // basic keypoint is we declare an object of class like java and use this for setup a connection
    // like: SELECT d FROM Department d WHERE d.name =?1
    // then =?1 refers to parameter order like =?2 refers to second parameter
    // or  =:salary we can use directly parameter name after colon and use this parameter with @Param("salary") int salary
    // should use entity name as a columns instead of table name in sql in contrast of native

    //Write a JPQL query that returns all accounts


    @Query("SELECT a FROM Account a")
    List<Account> getAllAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM Account a WHERE a.userRole='ADMIN'")
    List<Account> getAllAdminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a FROM Account a ORDER BY a.age DESC ")
    List<Account> getSortedAllAccountsInDesc();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city

    //Write a native query to read all accounts with an age lower than a specific value

}
