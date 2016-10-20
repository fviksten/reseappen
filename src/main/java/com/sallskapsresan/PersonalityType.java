package com.sallskapsresan;

/**
 * Created by Administrator on 2016-10-18.
 */
public enum PersonalityType {
    INTJ,
    INTP,
    ENTJ ,
    ENTP,
    INFJ,
    INFP,
    ENFJ,
    ENFP,
    ISTJ,
    ISFJ,
    ESTJ,
    ESFJ,
    ISTP,
    ISFP,
    ESTP,
    ESFP;

    public PersonalityType getPersonalityType(String type) {
        PersonalityType personalityType;
        if (type == "INTJ") {
            personalityType = INTJ;
        } else if (type == "INTP"){
            personalityType = INTP;
        } else if (type == "ENTJ") {
            personalityType = ENTJ;
        } else if (type == "ENTP"){
            personalityType = ENTP;
        } else if (type == "INFJ") {
            personalityType = INFJ;
        } else if (type == "INFP") {
            personalityType = INFP;
        } else if (type == "ENFJ") {
            personalityType = ENFJ;
        } else if (type == "ENFP") {
            personalityType = ENFP;
        } else if (type == "ISTJ"){
            personalityType = ISTJ;
        } else if (type == "ISFJ") {
            personalityType = ISFJ;
        } else if (type == "ESTJ"){
            personalityType = ESTJ;
        } else if (type == "ESFJ") {
            personalityType = ESFJ;
        } else if (type == "ISTP") {
            personalityType = ISTP;
        } else if (type == "ISFP") {
            personalityType = ISFP;
        } else if (type == "ESTP") {
            personalityType = ESTP;
        } else if (type == "ESFP") {
            personalityType = ESFP;
        } else {
            throw new RuntimeException("Ingen sådan användartyp finns: " + type);
        }
        return personalityType;
    }
}
