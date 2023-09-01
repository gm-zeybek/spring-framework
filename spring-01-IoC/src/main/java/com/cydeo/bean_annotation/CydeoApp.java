package com.cydeo.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class,ConfigAny.class);

        FullTimeMentor ft = container.getBean(FullTimeMentor.class);
//        PartTimeMentor pt1 = container.getBean("p1",PartTimeMentor.class);//assigning name to bean
//        PartTimeMentor pt2 = container.getBean("p2",PartTimeMentor.class);
        PartTimeMentor pt = container.getBean(PartTimeMentor.class);
        pt.createAccount();
        ft.createAccount();
//        pt1.createAccount();
//        pt2.createAccount();
        String str = container.getBean(String.class);
        System.out.println(str);

    }
}
