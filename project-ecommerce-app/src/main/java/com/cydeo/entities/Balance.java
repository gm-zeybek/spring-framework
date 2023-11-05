package com.cydeo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Balance extends BaseEntity{

    private BigDecimal amount;
    @OneToOne
    private BigInteger customerId;


}
