package com.example.dependencyInjection;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java {
//@Autowired// if there is one constructor then autowired can be removed
//    public Java(OfficeHours officeHours) {
//    this.officeHours = officeHours;
//    }
    OfficeHours officeHours;

    public void getTeachingHours(){
        System.out.println("Weekly teaching hours= " + (20 + officeHours.getHours()));
    }
}
