package com.crud.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId) {
        super("Could not found the user with id "+userId);
    }
}
