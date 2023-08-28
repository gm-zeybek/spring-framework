package com.example.springshort2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherConfig {
    @Bean
    String str(){
        return "spring short videos";
    }
    @Bean
    Integer integer(){
        return 100;
    }
}
