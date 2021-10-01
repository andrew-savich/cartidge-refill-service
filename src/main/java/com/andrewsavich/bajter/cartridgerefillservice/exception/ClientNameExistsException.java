package com.andrewsavich.bajter.cartridgerefillservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ClientNameExistsException extends RuntimeException{
    public ClientNameExistsException(String message){
        super(message);
    }
}
