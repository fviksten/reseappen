package com.sallskapsresan;

/**
 * Created by Administrator on 2016-10-18.
 */
public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String eMail;
    private String password;

    //Initial constructor
    public User(String firstName, String lastName, String userName, String eMail, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.eMail = eMail;
        this.password = password;
    }

    //sets the personality type
//    public void setPersonalityType(PersonalityType personalityType) {
//        this.personalityType = personalityType;
//    }

    //getters for all fields
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String geteMail() {
        return eMail;
    }

//    public PersonalityType getPersonalityType() {
//        return personalityType;
//    }
}