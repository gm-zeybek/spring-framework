package com.cydeo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DialarApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCar.class);
        Car carBean = context.getBean(Car.class);
        Person personBean = context.getBean(Person.class);
        System.out.println("Car make is " + carBean.getMake());
        System.out.println("Person name is " + personBean.getName());
        System.out.println("Person car is " + personBean.getCar().getMake());
    }
}