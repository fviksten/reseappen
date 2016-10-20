package com.sallskapsresan;

import com.google.gson.*;

public class Answer {

    public PersonalityType setType(String jsonLine) {

        String result = parser(jsonLine);
        PersonalityType type = PersonalityType.ENFJ;

        int counterI = 0;
        int counterE = 0;
        int counterN = 0;
        int counterS = 0;
        int counterF = 0;
        int counterT = 0;
        int counterJ = 0;
        int counterP = 0;

        for (char c : result.toCharArray()) {
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
//        if (counterI > counterE) {sb.append('I');}
//        else {sb.append('E');}
//        if (counterN > counterS) {sb.append('N');}
//        else {sb.append('S');}
//        if (counterF > counterT) {sb.append('F');}
//        else {sb.append('T');}
//        if (counterJ > counterP) {sb.append('J');}
//        else {sb.append('P');}

//        for (PersonalityType pt : PersonalityType.values()) {
//            if (pt.name().equalsIgnoreCase(sb.toString())) {
//                type = pt;
//            }
//        }

        if (counterI > counterE) {
            if (counterN > counterS) {
                if (counterF > counterT) {
                    if (counterJ > counterP) {
                        type = PersonalityType.INFJ;
                    }
                    else {type = PersonalityType.INFP;}
                }
                else {
                    if (counterJ > counterP) {
                        type = PersonalityType.INTJ;
                    } else {
                        type = PersonalityType.INTP;
                    }
                }
            }
            else {
                if (counterF > counterT) {
                    if (counterJ > counterP) {
                        type = PersonalityType.ISFJ;
                    }
                    else {type = PersonalityType.ISFP;}
                }
                else {
                    if (counterJ > counterP) {
                        type = PersonalityType.ISTJ;
                    } else {
                        type = PersonalityType.ISTP;
                    }
                }
            }
        }
        else {
            if (counterN > counterS) {
                if (counterF > counterT) {
                    if (counterJ > counterP) {
                        type = PersonalityType.ENFJ;
                    }
                    else {type = PersonalityType.ENFP;}
                }
                else {
                    if (counterJ > counterP) {
                        type = PersonalityType.ENTJ;
                    } else {
                        type = PersonalityType.ENTP;
                    }
                }
            }
            else {
                if (counterF > counterT) {
                    if (counterJ > counterP) {
                        type = PersonalityType.ESFJ;
                    }
                    else {type = PersonalityType.ESFP;}
                }
                else {
                    if (counterJ > counterP) {
                        type = PersonalityType.ESTJ;
                    } else {
                        type = PersonalityType.ESTP;
                    }
                }
            }

        }

        return type;
    }

    private String parser(String jsonLine) {
        StringBuilder type = new StringBuilder();

        JsonElement jelement = new JsonParser().parse(jsonLine);
        JsonObject jobject = jelement.getAsJsonObject();
        JsonArray jarray = jobject.getAsJsonArray("persForm");

        for (int i = 0; i < jarray.size(); i++) {
            jobject = jarray.get(i).getAsJsonObject();
            String s = jobject.get("result").toString().substring(1,2);
            type.append(s);
        }

        return type.toString();
    }

}
