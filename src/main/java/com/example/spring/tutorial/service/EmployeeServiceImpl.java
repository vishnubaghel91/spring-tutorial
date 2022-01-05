package com.example.spring.tutorial.service;

import com.example.spring.tutorial.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // concern
    // -- get emp by id --- main concern
    // logg concern -- log start and end details

    @Override

    public Employee getEmployeeById(long id) {
        System.out.println("get employee by id = " + id);
        Employee employee = new Employee(1, "Dummy");
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        System.out.println("saving employee = " + employee);
        Employee emp = new Employee(1, "Dummy");
        return emp;
    }
}
