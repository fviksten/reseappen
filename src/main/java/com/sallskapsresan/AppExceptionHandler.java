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
    public void handleSQLExceptions(RuntimeException e) {
        String errorMessage = "There was a problem";
        System.out.println(errorMessage);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Object> handleInvalidInputException(InvalidInputException e, WebRequest webRequest) {
        InvalidInputException iie = (InvalidInputException) e;
        List<FieldErrorResource> fieldErrorResources = new ArrayList<>();

        List<FieldError> fieldErrors = iie.getErrors().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            FieldErrorResource fieldErrorResource = new FieldErrorResource();
            fieldErrorResource.setResource(fieldError.getObjectName());
            fieldErrorResource.setField(fieldError.getField());
            fieldErrorResource.setCode(fieldError.getCode());
            fieldErrorResource.setMessage(fieldError.getDefaultMessage());
            fieldErrorResources.add(fieldErrorResource);
        }

        ErrorResource error = new ErrorResource("Invalid input", iie.getMessage());
        error.setFieldErrors(fieldErrorResources);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        for (FieldErrorResource fieldErrorResource : error.getFieldErrors()) {
            System.out.println(fieldErrorResource.getMessage());
            System.out.println(fieldErrorResource.getCode());
            System.out.println(fieldErrorResource.getField());
            System.out.println(fieldErrorResource.getResource());
        }

        return handleExceptionInternal(e, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, webRequest);
    }
}
