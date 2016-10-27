package com.sallskapsresanUtils;

import com.sallskapsresanPersonalTest.PersonalityType;
import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Administrator on 2016-10-18.
 */
public class User {

    private Long userID;

    @NotNull (message="Firstname is a manadatory field!")
    @Size (min=1, max=30, message="Firstname may be between one and 30 characters long!")
    private String firstname;

    @NotNull (message="Lastname is a mandatory field!")
    @Size (min=1, max=30, message="Lastname may be between one and 30 characters long!")
    private String lastname;

    @NotNull (message="Username is a mandatory field!")
    @Size (min=6, max=20, message="Username may be between six and 20 characters long!")
    private String username;

    @NotNull (message="Email is a mandatory field!")
    @Email (message="The email-format does not meet the requirements!")
    private String email;

    @NotNull (message="Password is a mandatory field!")
    private String password;
    private PersonalityType personalityType;

    //empty constructor to make it work with angular
    public User() {
    }

    //setters to make it work with angular
    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setPersonalityType(PersonalityType personalityType) {
        this.personalityType = personalityType;
    }

    //getters

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getUserID() {
        return userID;
    }

    public PersonalityType getPersonalityType() {
        return personalityType;
    }

}