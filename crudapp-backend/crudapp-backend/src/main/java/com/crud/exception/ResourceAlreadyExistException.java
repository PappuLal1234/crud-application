package com.crud.exception;

import javax.validation.constraints.NotEmpty;

public class ResourceAlreadyExistException extends RuntimeException {
    public ResourceAlreadyExistException( String email) {
        super("This email address already present "+email);
    }
}
