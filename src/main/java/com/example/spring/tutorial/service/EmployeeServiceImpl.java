package com.example.spring.tutorial.service;

import com.example.spring.tutorial.dao.EmployeeDaoImpl;
import com.example.spring.tutorial.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // concern
    // -- get emp by id --- main concern
    // logg concern -- log start and end details
    @Autowired
    private EmployeeDaoImpl employeeDaoImpl;
    @Override

    public Employee getEmployeeById(long id) {
        System.out.println("get employee by id = " + id);
       return  employeeDaoImpl.get(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        System.out.println("saving employee = " + employee);
        return  employeeDaoImpl.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("fetched all the employees");
        return employeeDaoImpl.getAll();
    }
}
