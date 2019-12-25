package com.ibnshayed.www.exception;

public class ResourceAlreadyExistsException extends Exception {
    public ResourceAlreadyExistsException(String id) {
        super(id + " already exists!");
    }

}
