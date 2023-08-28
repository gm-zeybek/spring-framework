package com.example.dependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class OfficeHours {
    public Integer getHours(){
        return 10;
    }
}
