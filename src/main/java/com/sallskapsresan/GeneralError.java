package com.sallskapsresan;

/**
 * Created by Administrator on 2016-10-27.
 */
public abstract class GeneralError {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
