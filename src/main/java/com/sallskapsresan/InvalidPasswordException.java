package com.sallskapsresan;

import org.springframework.validation.Errors;

/**
 * Created by Administrator on 2016-10-25.
 */
public class InvalidPasswordException extends RuntimeException {
    private Errors errors;

    public InvalidPasswordException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
