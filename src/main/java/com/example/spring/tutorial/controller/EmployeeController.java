package com.example.spring.tutorial.controller;

import com.example.spring.tutorial.model.Employee;
import com.example.spring.tutorial.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController ()
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping (path = "/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping (path = "")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        Employee emp = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(emp);
    }

    @GetMapping(path ="")
    public ResponseEntity<List<Employee>> getAllEmployee(){
         List<Employee> emp = employeeService.getAllEmployees();
         return ResponseEntity.ok(emp);
    }

    //@PutMapping(path ="/")
    
}
