package com.andrewsavich.bajter.cartridgerefillservice.exception.client;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message) {
        super(message);
    }
}
