package com.andrewsavich.bajter.cartridgerefillservice.service.employee;

import com.andrewsavich.bajter.cartridgerefillservice.exception.employee.EmployeeLoginExistException;
import com.andrewsavich.bajter.cartridgerefillservice.exception.employee.EmployeeNotFoundException;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Employee;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Position;
import com.andrewsavich.bajter.cartridgerefillservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (Objects.isNull(employee)) {
            throw new EmployeeNotFoundException("Employee with id: " + id + " mot found");
        }

        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {

        if (isExistSameLogin(employee)) {
            throw new EmployeeLoginExistException("Employee with login '" + employee.getLogin() + "' exists");
        }

        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {

        if (isExistSameLogin(employee)) {
            throw new EmployeeLoginExistException("Employee with login '" + employee.getLogin() + "' exists");
        }

        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (Objects.isNull(employee)) {
            throw new EmployeeNotFoundException("Employee with id: " + id + " mot found");
        }

        employeeRepository.delete(employee);
    }

    @Override
    public List<Position> getAllEmployeePositions() {
        return Arrays.asList(Position.values());
    }

    private boolean isExistSameLogin(Employee checkingEmployee) {
        Employee existingEmployee = employeeRepository.findByLogin(checkingEmployee.getLogin());

        //case for the creating a new checkingEmployee without existing same login in the DB
        if (checkingEmployee.getId() == null) {
            return existingEmployee != null;
        }

        //case for the updating existing checkingEmployee
        if (existingEmployee == null) {
            return false;
        } else {
            return existingEmployee.getId() != checkingEmployee.getId();
        }
    }

}