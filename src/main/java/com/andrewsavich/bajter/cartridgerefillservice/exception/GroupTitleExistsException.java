package com.andrewsavich.bajter.cartridgerefillservice.exception;

public class GroupTitleExistsException extends RuntimeException{
    public GroupTitleExistsException(String message) {
        super(message);
    }
}
