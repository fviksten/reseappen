package com.sallskapsresan;

import java.util.List;

/**
 * Created by Administrator on 2016-10-24.
 */
public class UserValidationErrorResource extends ErrorResource {
    private List<UserValidationError> userValidationErrors;

    public UserValidationErrorResource() {
    }

    public void setUserValidationErrors(List<UserValidationError> userValidationErrors) {
        this.userValidationErrors = userValidationErrors;
    }

    public List<UserValidationError> getUserValidationErrors() {
        return userValidationErrors;
    }
}
