package com.sallskapsresan;

/**
 * Created by Administrator on 2016-10-24.
 */
public class UserValidationError extends GeneralError {
    private String field;
    private String code;

    public void setField(String field) {
        this.field = field;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getField() {
        return field;
    }

    public String getCode() {
        return code;
    }
}
