package com.sallskapsresan;

import java.util.List;

/**
 * Created by Administrator on 2016-10-24.
 */
public class ValidationErrorResource extends ErrorResource {
    private String code;
    private String message;
    private List<FieldErrorResource> fieldErrors;

    public ValidationErrorResource() {
    }

    public ValidationErrorResource(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFieldErrors(List<FieldErrorResource> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<FieldErrorResource> getFieldErrors() {
        return fieldErrors;
    }
}
