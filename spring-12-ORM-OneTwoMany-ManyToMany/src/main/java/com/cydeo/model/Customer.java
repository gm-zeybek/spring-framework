package com.cydeo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String username;
    private String name;
    private String surname;
    private String email;
    private String address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Payment> payment;


    public Customer(String username, String name, String surname, String email, String address) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }
}
