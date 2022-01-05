package com.example.spring.tutorial.dao;

import com.example.spring.tutorial.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee save(Employee employee);

    Employee get(long id);
    List<Employee> getAll();
}
