package com.cydeo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@AllArgsConstructor
@Component
public class Java {
    // field injection
//    @Autowired // field injection not recommended
//    OfficeHours officeHours;

    // constructor injection
    OfficeHours officeHours;

//    @Autowired// recommended
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    public void getTeachingHours(){
        System.out.println("Weekly teaching hours:" + (20 + officeHours.getHours()));

    }
}
