package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.EmployeeLoginExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Employee;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Position;
import com.andrewsavich.bajter.cartridgerefillservice.service.employee.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployeeList() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/positions")
    public List<Position> getEmployeePositions() {
        return employeeService.getAllEmployeePositions();
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping
    public void createEmployee(@Valid @RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
    }

}
