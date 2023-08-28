package com.example.stereoTypeAnnotation;

import com.example.springshort2.FullTimeMentor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigCourse.class);
        Java java = container.getBean(Java.class);
        Agile agile = container.getBean(Agile.class);
//        Selenium selenium = container.getBean(Selenium.class); since we didn't assign it is not giving object
        java.getTeachingHours();
        agile.getTeachingHours();
//        selenium.getTeachingHours();
        FullTimeMentor ft = container.getBean(FullTimeMentor.class);// it can be eligible outside the package with configScan(basePackage="")
        ft.createAccount();

    }
}
