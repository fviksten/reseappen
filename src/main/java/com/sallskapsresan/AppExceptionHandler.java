package com.sallskapsresan;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-24.
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRunTimeExceptions(RuntimeException e, WebRequest webRequest) {


        List<RuntimeError> runtimeExceptionResources = new ArrayList<>();
        RuntimeError runtimeError = new RuntimeError();
        runtimeError.setMessage(e.getMessage());
        runtimeExceptionResources.add(runtimeError);

        RuntimeErrorResource error = new RuntimeErrorResource();
        error.setRuntimeErrors(runtimeExceptionResources);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.SERVICE_UNAVAILABLE, webRequest);

    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Object> handleInvalidInputException(InvalidInputException e, WebRequest webRequest) {

        InvalidInputException iie = (InvalidInputException) e;

        List<FieldError> fieldErrors = iie.getErrors().getFieldErrors();

        List<UserValidationError> userValidationErrorResources = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            UserValidationError userValidationErrorResource = new UserValidationError();
            userValidationErrorResource.setField(fieldError.getField());
            userValidationErrorResource.setCode(fieldError.getCode());
            userValidationErrorResource.setMessage(fieldError.getDefaultMessage());
            userValidationErrorResources.add(userValidationErrorResource);
        }

        UserValidationErrorResource error = new UserValidationErrorResource();
        error.setUserValidationErrors(userValidationErrorResources);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Object> handleInvalidPasswordException(InvalidPasswordException e, WebRequest webRequest) {
        InvalidPasswordException ipe = (InvalidPasswordException) e;
        ErrorResource error = new ErrorResource("Invalid input", ipe.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.BAD_REQUEST, webRequest);
    }
}
