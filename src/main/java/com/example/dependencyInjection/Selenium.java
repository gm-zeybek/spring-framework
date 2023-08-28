package com.example.dependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class Selenium {
    OfficeHours officeHours;
    public void getTeachingHours(){
        System.out.println("Weekly teaching hours" + 15+officeHours.getHours());
    }
}
