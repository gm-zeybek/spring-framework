package com.cydeo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Orders extends BaseEntity{
    private BigDecimal paidPrice;
    private BigDecimal totalPrice;
    private BigInteger cartId;
    private BigInteger customerId;
    private BigInteger paymentId;


}
