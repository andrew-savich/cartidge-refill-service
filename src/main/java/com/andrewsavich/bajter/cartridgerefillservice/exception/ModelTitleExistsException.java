package com.andrewsavich.bajter.cartridgerefillservice.exception;

public class ModelTitleExistsException extends RuntimeException{
    public ModelTitleExistsException(String message) {
        super(message);
    }
}
