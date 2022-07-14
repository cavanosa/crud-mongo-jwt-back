package com.tutorial.crudmongoback.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AttributeException extends Exception {
    public AttributeException(String message) {
        super(message);
    }
}
