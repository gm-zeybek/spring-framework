package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public class Student {
    private UUID id;
    private String firstName;
    private String lastName;
}
