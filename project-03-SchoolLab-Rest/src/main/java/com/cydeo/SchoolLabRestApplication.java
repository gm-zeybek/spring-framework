package com.cydeo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// TODO: TO ADD @EnableFeignClients ANNOTATION TO START API CALL
@EnableFeignClients // first thing we need to add this on runner class
public class SchoolLabRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolLabRestApplication.class, args);
    }
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
