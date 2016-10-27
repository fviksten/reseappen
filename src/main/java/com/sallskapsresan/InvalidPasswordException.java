package com.sallskapsresan;

import org.springframework.validation.Errors;

/**
 * Created by Administrator on 2016-10-25.
 */
public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String message) {
        super(message);
    }
}
