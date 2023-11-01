package com.cydeo.bootstrap;

import com.cydeo.enums.Status;
import com.cydeo.model.Merchant;
import com.cydeo.model.Payment;
import com.cydeo.model.PaymentDetail;
import com.cydeo.repository.MerchantRepository;
import com.cydeo.repository.PaymentRepostitory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    private final PaymentRepostitory paymentRepostitory;
    private final MerchantRepository merchantRepository;

    public DataGenerator(PaymentRepostitory paymentRepostitory, MerchantRepository merchantRepository) {
        this.paymentRepostitory = paymentRepostitory;
        this.merchantRepository = merchantRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Payment payment1 = new Payment (LocalDate. of ( 2022, 4, 19), new BigDecimal (  "150000"), Status.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal( "140000") , new BigDecimal ( "10000") , LocalDate.of(  2022,  4,  24));
        payment1.setPaymentDetail (paymentDetail1);
        Payment payment2 = new Payment (LocalDate. of( 2022, 4,  25), new BigDecimal( "100000"), Status .FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail (new BigDecimal(  "90000") , new BigDecimal (  "5000"), LocalDate.of( 2022,  4,  29));
        payment2.setPaymentDetail (paymentDetail2);

        Merchant merchant1 = new Merchant ("AmazonSubMerchant", "M123", new BigDecimal ("0.25") , new BigDecimal ("3.25"), 5);


        paymentRepostitory.save(payment1);
        paymentRepostitory.save(payment2);

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant1);
        merchantRepository.save(merchant1);

    }
}
