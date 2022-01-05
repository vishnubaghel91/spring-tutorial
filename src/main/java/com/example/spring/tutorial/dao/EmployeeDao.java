package com.example.spring.tutorial.dao;

import com.example.spring.tutorial.model.Employee;

public interface EmployeeDao {

    Employee save(Employee employee);

    Employee get(long id);
}
