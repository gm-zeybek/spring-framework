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
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;
                                        // owner is the employee table because other table has no column related employee
    @ManyToOne // this automatically create department_id
    @JoinColumn(name = "department") // instead of department_id data have department
    private Department department;
    @ManyToOne// this automatically create region_id
    @JoinColumn(name = "region_id")
    private Region region;
}
