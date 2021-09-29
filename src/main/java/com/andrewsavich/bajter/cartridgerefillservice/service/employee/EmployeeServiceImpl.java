package com.andrewsavich.bajter.cartridgerefillservice.service.employee;

import com.andrewsavich.bajter.cartridgerefillservice.repository.EmployeeRepository;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Employee;
import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public List<Position> getAllEmployeePositions(){
        return Arrays.asList(Position.values());
    }

    @Override
    public boolean isExistSameLogin (Employee checkingEmployee){
        Employee existingEmployee = employeeRepository.findByLogin(checkingEmployee.getLogin());

        //case for the creating a new checkingEmployee without existing same login in the DB
        if(checkingEmployee.getId() == null){
            if(existingEmployee == null){
                return false;
            } else {
                return true;
            }
        }

        //case for the updating existing checkingEmployee
        if(existingEmployee == null){
            return false;
        } else {
            if(existingEmployee.getId() == checkingEmployee.getId()){
                return false;
            }
        }

        return true;
    }


}