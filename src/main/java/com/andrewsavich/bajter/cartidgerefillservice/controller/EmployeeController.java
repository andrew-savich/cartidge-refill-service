package com.andrewsavich.bajter.cartidgerefillservice.controller;

import com.andrewsavich.bajter.cartidgerefillservice.model.employee.Employee;
import com.andrewsavich.bajter.cartidgerefillservice.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getEmployeeList(){
        return employeeService.getAllEmployee();
    }
}
