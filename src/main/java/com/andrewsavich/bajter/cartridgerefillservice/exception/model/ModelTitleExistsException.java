package com.andrewsavich.bajter.cartridgerefillservice.exception.model;

public class ModelTitleExistsException extends RuntimeException{
    public ModelTitleExistsException(String message) {
        super(message);
    }
}
