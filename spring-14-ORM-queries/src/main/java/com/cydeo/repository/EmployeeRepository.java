package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // find all employees have specific email address
    List<Employee> findByEmail(String pattern);

    // display all employees have firstname is and lastname is or has email is
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    // display all employees first name is not
    List<Employee> findByEmailNot(String email);

    // display all employee last name start with
    List<Employee> findByLastNameStartsWith(String pattern);

    // display all employees who's salaries are higher than " "
    List<Employee> findEmployeeBySalaryGreaterThan(Integer threshold);

    // display all employees who's salaries are less thank " "
    List<Employee> findEmployeeBySalaryLessThanEqual(Integer threshold);

    // Display all employees who are hired between '' and '' dates
    List<Employee> findEmployeeByHireDateBetween(LocalDate startDate, LocalDate finishDate);

    // Displays all employees who's salary greater and equal and order
    List<Employee> findEmployeeBySalaryGreaterThanEqual(Integer salary);

    // display unique 3 employees top 3 salary less than
    List<Employee> findDistinctTop3BySalaryIsLessThanEqual(Integer salary);

    // display who has not email address
    List<Employee> findEmployeeByEmailIsNull();

    // @Query JPQL query use pojo classes instead of table

    @Query("SELECT e FROM Employee e WHERE e.email='btrow5@technorati.com'")  // Employee is class
    List<Employee> findEmployeeDetails();

    @Query("SELECT e.salary FROM Employee e WHERE e.email='btrow5@technorati.com'")
    Integer getEmployeeSalary();

    // parameter in position ?!,?1
    @Query("SELECT e FROM Employee e WHERE e.email= ?1")
    Optional<Employee> getEmployeeDetails(String email);

    @Query("SELECT e FROM Employee e WHERE e.email= ?1 AND e.salary=?2")
    Optional<Employee> getEmployeeDetails(String email, Integer salary);

    // find employees salary not equal to
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> findEmployeeSalaryNotEqual(Integer salary);

    // LIke/contains/startsWith/endsWith
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> findEmployeeByFirstNameLike(String pattern);

    // find employees whose salary is between
//    @Query("SELECT e FROM Employee e WHERE e.salary>?1 AND e.salary<?2")
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> findEmployeeBySalaryBetween(int salary1, int salary2);

    // email is null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> findEmployeesByEmailIsNull();

    // ISNOT NULL
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> findEmployeesByEmailIsNOTNull();
    // order by
    @Query("SELECT e FROM Employee e ORDER BY e.salary asc ")
    List<Employee> getEmployeeOrdeOrderBySalary();

    // NATIVE QUERY

    @Query(value = "SELECT * FROM employees WHERE salary ?1",nativeQuery = true)
    List<Employee> readEmployeeDetailsBySalary(int Salary);

    // NAME PARAMETERS
    // use : <parameter> column operator and @Param("<param name>")
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> getEmployeeSalary(@Param("salary") int Salary);

    // UPDATE/ DELETE / MODIFY

    // use @Modifying and @Transactional parameters
    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email = 'admin@email.com' WHERE e.Id = :id")
    void updateEmployeeJPQL(@Param("id") int id);



}
