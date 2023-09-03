package com.cydeo.repository;

import com.cydeo.model.Employee;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)

public class DBEmployeeRepository implements EmployeeRepository{



    @Override
    public int getHourlyRates(Employee employee) {
        return employee.getHourlyRates();
    }
}
