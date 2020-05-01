package com.blooddonate.eis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DonorIdException extends RuntimeException {
    public DonorIdException(String message) {
        super(message);
    }
}
