package com.cydeo.steriotype_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCourse.class);
        Agile bean = context.getBean(Agile.class);
        bean.getTeachingHours();
    }
}
