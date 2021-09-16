package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Employee;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Position;
import com.andrewsavich.bajter.cartridgerefillservice.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getEmployeeList(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/positions")
    public List<Position> getEmployeePositions(){
        return employeeService.getAllEmployeePositions();
    }

    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee){
        System.out.println("got employee from front: " + employee);

        employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        System.out.println("Got id from client: " + id);
        Employee employee = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(employee);
    }

}
