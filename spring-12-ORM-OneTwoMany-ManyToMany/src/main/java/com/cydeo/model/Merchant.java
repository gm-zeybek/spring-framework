package com.cydeo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "merchants")
@Data
@NoArgsConstructor
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String code;
    private BigDecimal trancactionFee;
    private BigDecimal commisionRate;
    private Integer payoutDelayCount;

    @OneToMany(mappedBy = "merchant") // onetwomany relationship ownerhsip belongs to many side
    private List<Payment> payment;

    public Merchant(String name, String code, BigDecimal trancactionFee, BigDecimal commisionRate, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.trancactionFee = trancactionFee;
        this.commisionRate = commisionRate;
        this.payoutDelayCount = payoutDelayCount;
    }
}
