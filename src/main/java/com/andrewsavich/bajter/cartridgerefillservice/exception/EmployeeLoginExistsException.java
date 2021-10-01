package com.andrewsavich.bajter.cartridgerefillservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EmployeeLoginExistsException extends RuntimeException{
    public EmployeeLoginExistsException(String message) {
        super(message);
    }
}