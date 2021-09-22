package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.LoginExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Employee;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Position;
import com.andrewsavich.bajter.cartridgerefillservice.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void createEmployee(@RequestBody Employee employee) {
        if (employeeService.isExistSameLogin(employee)){
            throw new LoginExistsException("Employee with this login allreay exist!");
        }

        employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee changedEmployee){
        Employee employee = employeeService.getEmployeeById(id);
        employee.updateFields(changedEmployee);

        if(employeeService.isExistSameLogin(employee)){
            throw new LoginExistsException("Employee with this login allreay exist!");
        }

        Employee updatedEmployee = employeeService.saveEmployee(employee);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);

        employeeService.deleteEmployee(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Dleted", true);

        return ResponseEntity.ok(response);
    }

}
