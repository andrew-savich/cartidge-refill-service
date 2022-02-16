package com.andrewsavich.bajter.cartridgerefillservice.exception.employee;

public class EmployeeLoginExistException extends RuntimeException {
    public EmployeeLoginExistException(String message) {
        super(message);
    }
}
