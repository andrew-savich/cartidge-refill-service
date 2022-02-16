package com.andrewsavich.bajter.cartridgerefillservice.exception.employee;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}