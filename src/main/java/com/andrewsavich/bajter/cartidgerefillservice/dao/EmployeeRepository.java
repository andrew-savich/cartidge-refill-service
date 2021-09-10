package com.andrewsavich.bajter.cartidgerefillservice.dao;

import com.andrewsavich.bajter.cartidgerefillservice.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
