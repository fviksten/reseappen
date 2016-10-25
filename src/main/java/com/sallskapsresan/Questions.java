package com.sallskapsresan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-19.
 */
public class Questions {

    private User user;
    private List<Question> persForm;

    public Questions() {
        this.persForm = new ArrayList<>();
    }

    public void setPersForm(List<Question> persForm) {
        this.persForm = persForm;
    }

    public List<Question> getPersForm() {
        return persForm;
    }

    public User getUser() {
        this.user.setPersonalityType(getType());
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PersonalityType getType() {

        StringBuilder sb = new StringBuilder();

        for (Question question : persForm) {
            sb.append(question.getResult());
        }

        PersonalityType type = PersonalityType.DEFAULT;

        int counterI = 0;
        int counterE = 0;
        int counterN = 0;
        int counterS = 0;
        int counterF = 0;
        int counterT = 0;
        int counterJ = 0;
        int counterP = 0;

        for (char c : sb.toString().toCharArray()) {
            if (c == 'I') {
                counterI++;
            }
            if (c == 'E') {
                counterE++;
            }
            if (c == 'N') {
                counterN++;
            }
            if (c == 'S') {
                counterS++;
            }
            if (c == 'F') {
                counterF++;
            }
            if (c == 'T') {
                counterT++;
            }
            if (c == 'J') {
                counterJ++;
            }
            if (c == 'P') {
                counterP++;
            }
        }

        if (counterI > counterE) {
            if (counterN > counterS) {
                if (counterF > counterT) {
                    if (counterJ > counterP) {
                        type = PersonalityType.INFJ;
                    } else {
                        type = PersonalityType.INFP;
                    }
                } else {
                    if (counterJ > counterP) {
                        type = PersonalityType.INTJ;
                    } else {
                        type = PersonalityType.INTP;
                    }
                }
            } else {
                if (counterF > counterT) {
                    if (counterJ > counterP) {
                        type = PersonalityType.ISFJ;
                    } else {
                        type = PersonalityType.ISFP;
                    }
                } else {
                    if (counterJ > counterP) {
                        type = PersonalityType.ISTJ;
                    } else {
                        type = PersonalityType.ISTP;
                    }
                }
            }
        } else if (counterI < counterE) {
            if (counterN > counterS) {
                if (counterF > counterT) {
                    if (counterJ > counterP) {
                        type = PersonalityType.ENFJ;
                    } else {
                        type = PersonalityType.ENFP;
                    }
                } else {
                    if (counterJ > counterP) {
                        type = PersonalityType.ENTJ;
                    } else {
                        type = PersonalityType.ENTP;
                    }
                }
            } else {
                if (counterF > counterT) {
                    if (counterJ > counterP) {
                        type = PersonalityType.ESFJ;
                    } else {
                        type = PersonalityType.ESFP;
                    }
                } else {
                    if (counterJ > counterP) {
                        type = PersonalityType.ESTJ;
                    } else {
                        type = PersonalityType.ESTP;
                    }
                }
            }
        }
        else {type = PersonalityType.DEFAULT;}

        return type;
    }


}
