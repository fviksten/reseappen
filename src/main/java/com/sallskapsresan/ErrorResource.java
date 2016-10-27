package com.sallskapsresan;

import java.util.List;

/**
 * Created by Administrator on 2016-10-25.
 */
public class ErrorResource {

    private List<GeneralError> errors;

    public ErrorResource() {
    }

    public void setErrors(List<GeneralError> errors) {
        this.errors = errors;
    }

    public List<GeneralError> getErrors() {
        return errors;
    }
}
