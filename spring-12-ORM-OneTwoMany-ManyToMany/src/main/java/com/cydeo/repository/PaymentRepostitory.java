package com.cydeo.repository;

import com.cydeo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepostitory extends JpaRepository<Payment,Long> {
}
