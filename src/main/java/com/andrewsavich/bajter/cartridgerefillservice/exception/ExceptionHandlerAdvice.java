package com.andrewsavich.bajter.cartridgerefillservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(EmployeeLoginExistsException.class)
    public ResponseEntity handleException(EmployeeLoginExistsException e){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler(ClientNameExistsException.class)
    public ResponseEntity handleException(ClientNameExistsException e){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }

    @ExceptionHandler(GroupTitleExistsException.class)
    public ResponseEntity handleException(GroupTitleExistsException e){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }
}
