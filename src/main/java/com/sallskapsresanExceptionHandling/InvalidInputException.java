package com.sallskapsresanExceptionHandling;

import org.springframework.validation.Errors;

/**
 * Created by Administrator on 2016-10-24.
 */
public class InvalidInputException extends RuntimeException {
    private Errors errors;

    public InvalidInputException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}