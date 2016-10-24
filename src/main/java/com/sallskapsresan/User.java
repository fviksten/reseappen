package com.sallskapsresan;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Created by Administrator on 2016-10-18.
 */
public class User {

    private Long userID;

//    @NotNull
//    @Size (min=2, max=30)
    private String firstname;

//    @NotNull
//    @Size (min=2, max=30)
    private String lastname;

    @NotNull
    @Size (min=6, max=20)
    private String username;

//    @NotNull
//    @Email
    private String email;

//    @NotNull
    private String password;
//    private LocalDateTime joined;
//    private LocalDateTime lastlogin;
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

    //    public void setJoined(LocalDateTime joined) {
//        this.joined = joined;
//    }
//
//    public void setLastlogin(LocalDateTime lastlogin) {
//        this.lastlogin = lastlogin;
//    }

    public void setPersonalityType(PersonalityType personalityType) {
        this.personalityType = personalityType;
    }

    //getters
    public long getUserID () {
        return userID;
    }

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

    //
//    public LocalDateTime getJoined() {
//        return joined;
//    }
//
//    public LocalDateTime getLastlogin() {
//        return lastlogin;
//    }

    public PersonalityType getPersonalityType() {
        return personalityType;
    }
}