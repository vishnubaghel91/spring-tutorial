package com.example.spring.tutorial.service;

import com.example.spring.tutorial.model.Employee;

public interface EmployeeService {

    Employee getEmployeeById(long id);

    Employee saveEmployee(Employee employee);

}
