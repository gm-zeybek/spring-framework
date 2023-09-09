package com.cydeo;

import com.cydeo.config.EmpConfig;
import com.cydeo.model.Employee;
import com.cydeo.service.OverTimeSalaryService;
import com.cydeo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpApp {
    public static void main(String[] args) {
        // create object
        Employee emp1 = new Employee();
        emp1.setHourlyRates(20);

        ApplicationContext context = new AnnotationConfigApplicationContext(EmpConfig.class);
        SalaryService sa = context.getBean(SalaryService.class);
        sa.calculateRegularSalary(emp1);
        OverTimeSalaryService ove = context.getBean(OverTimeSalaryService.class);
        ove.calculateRegularSalary(emp1);
    }
}
