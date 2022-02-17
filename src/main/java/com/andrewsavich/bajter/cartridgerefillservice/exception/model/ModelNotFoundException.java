package com.andrewsavich.bajter.cartridgerefillservice.exception.model;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String message) {
        super(message);
    }
}
