package com.andrewsavich.bajter.cartridgerefillservice.exception;

import com.andrewsavich.bajter.cartridgerefillservice.exception.client.ClientNameExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.exception.client.ClientNotFoundException;
import com.andrewsavich.bajter.cartridgerefillservice.exception.employee.EmployeeLoginExistException;
import com.andrewsavich.bajter.cartridgerefillservice.exception.employee.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(EmployeeLoginExistException.class)
    public ResponseEntity handleEmployeeLoginExistException(EmployeeLoginExistException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(ClientNameExistsException.class)
    public ResponseEntity handleClientNameExistsException(ClientNameExistsException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity handleClientNotFoundException(ClientNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(GroupTitleExistsException.class)
    public ResponseEntity handleException(GroupTitleExistsException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler(ModelTitleExistsException.class)
    public ResponseEntity handleException(ModelTitleExistsException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler(CartridgeUniqueIdentifyException.class)
    public ResponseEntity handleException(CartridgeUniqueIdentifyException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }
}
