package com.cydeo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketingProjectOrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketingProjectOrmApplication.class, args);
	}

	// we can use this class as a beam for third party dependancy because springBootApplication annotation includes component annotation too.
	@Bean
	public ModelMapper mapper(){
		return new ModelMapper();
	}



}
