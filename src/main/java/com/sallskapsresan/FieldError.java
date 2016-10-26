package com.sallskapsresan;

/**
 * Created by Administrator on 2016-10-24.
 */
public class FieldError {
    private String field;
    private String code;
    private String message;

    public void setField(String field) {
        this.field = field;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
