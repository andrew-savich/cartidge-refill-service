package com.andrewsavich.bajter.cartridgerefillservice.exception.group;

public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(String message) {
        super(message);
    }
}
