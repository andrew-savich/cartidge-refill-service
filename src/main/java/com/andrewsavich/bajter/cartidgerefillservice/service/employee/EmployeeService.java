package com.andrewsavich.bajter.cartidgerefillservice.service.employee;

import com.andrewsavich.bajter.cartidgerefillservice.model.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long id);
    void saveEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
