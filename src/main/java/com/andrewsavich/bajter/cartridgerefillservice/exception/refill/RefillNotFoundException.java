package com.andrewsavich.bajter.cartridgerefillservice.exception.refill;

public class RefillNotFoundException extends RuntimeException {
    public RefillNotFoundException(String message) {
        super(message);
    }
}
