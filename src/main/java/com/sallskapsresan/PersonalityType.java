package com.sallskapsresan;

/**
 * Created by Administrator on 2016-10-18.
 */
public enum PersonalityType {
    DEFAULT,
    INTJ,
    INTP,
    ENTJ,
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

    public static PersonalityType getPersonalityType(String type) {
        for (PersonalityType pt : PersonalityType.values()) {
            if (pt.name().equalsIgnoreCase(type)) { return pt; }
        }
        return PersonalityType.DEFAULT;
    }
}
