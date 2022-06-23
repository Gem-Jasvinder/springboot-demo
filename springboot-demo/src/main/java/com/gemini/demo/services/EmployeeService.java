package com.springrestexample.demo.services;


import com.springrestexample.demo.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeService {

    public List<Employee> getEmployeeUser();

    public Employee addEmployeeUser(Employee employee);
}
