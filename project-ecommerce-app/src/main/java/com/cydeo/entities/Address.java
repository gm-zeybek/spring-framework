package com.cydeo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Address extends BaseEntity{
    private String name;
    private String street;
    private String zipCode;
    @ManyToOne
    private Customer customer;


}
