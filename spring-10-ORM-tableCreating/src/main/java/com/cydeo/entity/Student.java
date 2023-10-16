package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
