package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;

import java.math.BigDecimal;

@Entity
public class CreditAccount extends Account{
    private BigDecimal creditLimit;
}
