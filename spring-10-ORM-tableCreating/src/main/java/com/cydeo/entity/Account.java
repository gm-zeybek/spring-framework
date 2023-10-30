package com.cydeo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.math.BigDecimal;
@MappedSuperclass
public class Account {
    @Id
    private Long Id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;
}
