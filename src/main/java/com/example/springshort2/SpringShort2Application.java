package com.example.springshort2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringShort2Application {

    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class,AnotherConfig.class);

        FullTimeMentor ft = container.getBean(FullTimeMentor.class);
        ft.createAccount();
        PartTimeMentor pt = container.getBean(PartTimeMentor.class);
        pt.createAccount();
        String str = container.getBean(String.class);
        System.out.println(str);
        Integer integer = container.getBean(Integer.class);
        System.out.println(integer);
    }

}
