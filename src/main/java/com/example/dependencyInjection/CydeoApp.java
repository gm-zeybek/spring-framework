package com.example.dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigCourse.class);
        Java java = container.getBean(Java.class);
        java.getTeachingHours();


    }
}
