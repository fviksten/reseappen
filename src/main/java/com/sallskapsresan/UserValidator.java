package com.sallskapsresan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Administrator on 2016-10-23.
 */
public class UserValidator implements Validator {

    @Override
    public boolean supports (Class clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
    }
}
