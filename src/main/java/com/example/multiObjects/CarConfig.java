package com.example.multiObjects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CarConfig {

//    @Bean(name = "C1")
    @Bean
    @Primary// giving default bean
    Car car1(){
        Car c = new Car();
        c.setMake("BMW");
        return c;
    }
    @Bean(name = "C2")// naming bean inside the annotation
    Car car2(){
        Car c = new Car();
        c.setMake("Tesla");
        return c;
    }

}
