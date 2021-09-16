package com.andrewsavich.bajter.cartridgerefillservice.dao;

import com.andrewsavich.bajter.cartridgerefillservice.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
