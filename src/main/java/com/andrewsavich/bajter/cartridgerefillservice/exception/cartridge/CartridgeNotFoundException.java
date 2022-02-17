package com.andrewsavich.bajter.cartridgerefillservice.exception.cartridge;

public class CartridgeNotFoundException extends RuntimeException {
    public CartridgeNotFoundException(String message) {
        super(message);
    }
}
