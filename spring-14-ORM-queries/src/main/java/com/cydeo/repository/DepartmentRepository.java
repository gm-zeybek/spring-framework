package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    // display all department in the department
    List<Department> findByDepartment(String department);

    // display all department in health division
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    // display top 3 department division name includes 'hea' without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String division);
    // IN
    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> getDepartmentDivision(List<String> division);

    // NAMED QUERIES IN PROPERTIES FILE
    List<Department> findDepartmentByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> findDepartmentByContainDivision(String pattern);
}
