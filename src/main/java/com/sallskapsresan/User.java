package com.sallskapsresan;

import java.sql.Date;

/**
 * Created by Administrator on 2016-10-18.
 */
public class User {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private Date joined;
    private Date lastlogin;
    private PersonalityType personalityType;


    //empty constructor to make it work with angular
    public User() {
    }

    //setters to make it work with angular
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

    public void setJoined(Date joined) {
        this.joined = joined;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
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

    public Date getJoined() {
        return joined;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public PersonalityType getPersonalityType() {
        return personalityType;
    }
}