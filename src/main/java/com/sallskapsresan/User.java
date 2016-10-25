package com.sallskapsresan;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Created by Administrator on 2016-10-18.
 */
public class User {

    private Long userID;

    @NotNull (message="Fältet förnamn är obligatoriskt!")
    @Size (min=1, max=30, message="Förnamnet måste vara mellan en och 30 bokstäver långt!")
    private String firstname;

    @NotNull (message="Fältet efternamn är obligatoriskt!")
    @Size (min=1, max=30, message="Efternamnet måste vara mellan en och 30 bokstäver långt!")
    private String lastname;

    @NotNull (message="Fältet användarnamn är obligatoriskt!")
    @Size (min=6, max=20, message="Användarnamnet måste vara mellan sex och tjugo bokstäver långt!")
    private String username;

    @NotNull (message="Fältet epost är obligatoriskt!")
    @Email (message="Eposten angavs i ett felaktigt format!")
    private String email;

    @NotNull (message="Fältet lösenord är obligatoriskt!")
    private String password;
//    private LocalDateTime joined;
//    private LocalDateTime lastlogin;
    private PersonalityType personalityType;
    private String salt;


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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}