package bean_practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class bean_practice {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigEmployee.class,StringConfig.class);
        FullTimeEmployee fullTimeEmployee = context.getBean(FullTimeEmployee.class);
        fullTimeEmployee.createAccount();
        PartTimeEmployee partTimeEmployee = context.getBean(PartTimeEmployee.class);
        partTimeEmployee.createAccount();



        System.out.println(context.getBean("Welcome",String.class));// using custome Bean("Welcome")
        System.out.println(context.getBean("string", String.class));// using named method name

    }
}
