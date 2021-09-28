package com.andrewsavich.bajter.cartridgerefillservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class LoginExistsException extends RuntimeException{
    public LoginExistsException(String message) {
        super(message);
    }
}