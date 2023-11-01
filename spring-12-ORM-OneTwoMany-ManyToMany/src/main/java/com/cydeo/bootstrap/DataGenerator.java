package com.cydeo.bootstrap;

import com.cydeo.enums.Status;
import com.cydeo.model.Payment;
import com.cydeo.model.PaymentDetail;
import com.cydeo.repository.PaymentRepostitory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    private final PaymentRepostitory paymentRepostitory;

    public DataGenerator(PaymentRepostitory paymentRepostitory) {
        this.paymentRepostitory = paymentRepostitory;
    }

    @Override
    public void run(String... args) throws Exception {

        Payment payment1 = new Payment (LocalDate. of ( 2022, 4, 19), new BigDecimal (  "150000"), Status.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal( "140000") , new BigDecimal ( "10000") , LocalDate.of(  2022,  4,  24));
        payment1.setPaymentDetail (paymentDetail1);
        Payment payment2 = new Payment (LocalDate. of( 2022, 4,  25), new BigDecimal( "100000"), Status .FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail (new BigDecimal(  "90000") , new BigDecimal (  "5000"), LocalDate.of( 2022,  4,  29));
        payment2.setPaymentDetail (paymentDetail2);

        paymentRepostitory.save(payment1);
        paymentRepostitory.save(payment2);

    }
}
