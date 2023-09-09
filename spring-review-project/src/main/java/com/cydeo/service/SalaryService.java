package com.cydeo.service;

import com.cydeo.model.Employee;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SalaryService {


    EmployeeRepository er;
    HoursRepository regularHours;

    public SalaryService(EmployeeRepository er, @Qualifier("regularHours") HoursRepository regularHours) {
        this.er = er;
        this.regularHours = regularHours;
    }

    public void calculateRegularSalary(Employee employee){

        Integer hourRates = er.getHourlyRates(employee);
        Integer totalHours = regularHours.getHours();

        System.out.println("Salary is " + hourRates * totalHours);
    }
}
