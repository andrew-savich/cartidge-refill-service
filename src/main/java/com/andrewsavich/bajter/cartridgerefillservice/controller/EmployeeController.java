package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.EmployeeLoginExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Employee;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Position;
import com.andrewsavich.bajter.cartridgerefillservice.service.employee.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Returning employee list")
    @ApiResponse(responseCode = "200", description = "Employees were found", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping
    public List<Employee> getEmployeeList(){
        log.info("Controller: getting employee list");

        return employeeService.getAllEmployee();
    }

    @Operation(summary = "Returning employee position list")
    @ApiResponse(responseCode = "200", description = "Positions were found", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping("/positions")
    public List<Position> getEmployeePositions(){
        log.info("Controller: getting position list");

        return employeeService.getAllEmployeePositions();
    }

    @Operation(summary = "Returning employee by id")
    @ApiResponse(responseCode = "200", description = "Employee was found", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId){
        log.info("Controller: getting employee with id: " + employeeId);
        Employee employee = employeeService.getEmployeeById(employeeId);

        log.info("Controller: sending employee with id: " + employeeId);
        return ResponseEntity.ok(employee);
    }

    @Operation(summary = "Creating a new employee")
    @ApiResponse(responseCode = "200", description = "Employee was created", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PostMapping
    public void createEmployee(@Valid @RequestBody Employee employee) {
        log.info("Controller: Got employee for creating: " + employee);
        if (employeeService.isExistSameLogin(employee)){
            throw new EmployeeLoginExistsException("Employee with this login '" + employee.getLogin() + "' already exists!");
        }

        employeeService.createEmployee(employee);
    }

    @Operation(summary = "Updating employee")
    @ApiResponse(responseCode = "200", description = "Employee was updated", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PutMapping
    public void updateEmployee(@RequestBody Employee employee){
        log.info("Controller: Got employee for updating: " + employee);

        if(employeeService.isExistSameLogin(employee)){
            throw new EmployeeLoginExistsException("Employee with this login '" + employee.getLogin() + "' already exists!");
        }

        employeeService.updateEmployee(employee);
    }

    @Operation(summary = "Deleting employee by id")
    @ApiResponse(responseCode = "200", description = "Employee was deleted", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId){
        log.info("Controller: Deleting employee with id: " + employeeId);

        employeeService.deleteEmployeeById(employeeId);
    }

}
