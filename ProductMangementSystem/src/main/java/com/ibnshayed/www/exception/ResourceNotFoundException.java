package com.ibnshayed.www.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String id) {
        super(id + " not found.");
    }
}
