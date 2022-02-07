package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.EmployeeLoginExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Employee;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Position;
import com.andrewsavich.bajter.cartridgerefillservice.service.employee.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployeeList(){
        log.info("Controller: getting employee list");

        return employeeService.getAllEmployee();
    }

    @GetMapping("/positions")
    public List<Position> getEmployeePositions(){
        log.info("Controller: getting position list");

        return employeeService.getAllEmployeePositions();
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId){
        log.info("Controller: getting employee with id: " + employeeId);
        Employee employee = employeeService.getEmployeeById(employeeId);

        log.info("Controller: sending employee with id: " + employeeId);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public void createEmployee(@Valid @RequestBody Employee employee) {
        log.info("Controller: Got employee for creating: " + employee);
        if (employeeService.isExistSameLogin(employee)){
            throw new EmployeeLoginExistsException("Employee with this login '" + employee.getLogin() + "' already exists!");
        }

        employeeService.createEmployee(employee);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee){
        log.info("Controller: Got employee for updating: " + employee);

        if(employeeService.isExistSameLogin(employee)){
            throw new EmployeeLoginExistsException("Employee with this login '" + employee.getLogin() + "' already exists!");
        }

        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId){
        log.info("Controller: Deleting employee with id: " + employeeId);

        employeeService.deleteEmployeeById(employeeId);
    }

}
