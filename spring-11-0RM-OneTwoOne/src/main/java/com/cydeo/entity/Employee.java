package com.cydeo.entity;

import com.cydeo.enums.Gender;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor

public class Employee extends BaseEntity{


    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

//    private Department department;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private BigDecimal salary;


    public Employee(String firstName, String lastName, String email, LocalDate hireDate, Gender gender, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;
    }
}
