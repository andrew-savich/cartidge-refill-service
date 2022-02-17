package com.andrewsavich.bajter.cartridgerefillservice.exception.group;

public class GroupTitleExistsException extends RuntimeException{
    public GroupTitleExistsException(String message) {
        super(message);
    }
}
