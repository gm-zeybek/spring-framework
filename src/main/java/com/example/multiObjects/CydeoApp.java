package com.example.multiObjects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(CarConfig.class);

        Car c2 = container.getBean("C2",Car.class);// naming bean inside the annotation
        Car c1 = container.getBean(Car.class);// calling default bean
        System.out.println(c1.getMake());
    }
}
