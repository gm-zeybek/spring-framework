package com.cydeo.service;

import com.cydeo.model.Employee;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Salary {


    EmployeeRepository er;
    HoursRepository regularHours;
    HoursRepository overTimeHours;

    public Salary(EmployeeRepository er, HoursRepository regularHours, HoursRepository overTimeHours) {
        this.er = er;
        this.regularHours = regularHours;
        this.overTimeHours = overTimeHours;
    }

    public void calculateRegularSalary(Employee employee){

        Integer hourRates = er.getHourlyRates(employee);
        Integer totalHours = overTimeHours.getHours() + regularHours.getHours();

        System.out.println("Salary is " + hourRates * totalHours);
    }
}
