package com.sallskapsresan;

import java.util.List;

/**
 * Created by Administrator on 2016-10-24.
 */
public class ValidationErrorResource extends ErrorResource {
    private List<FieldError> fieldErrors;

    public ValidationErrorResource() {
    }

    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}
