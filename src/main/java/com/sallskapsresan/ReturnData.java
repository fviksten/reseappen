package com.sallskapsresan;

/**
 * Created by Emil Båth on 2016-10-19.
 */
public class ReturnData {
    String message;
    User user;

    public ReturnData() {
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
