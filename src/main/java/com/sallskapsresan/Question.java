package com.sallskapsresan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-19.
 */
public class Question {

    private String question;
    private List<String> options;
    private List<String> answer;
    private String result;

    public Question() {
        this.options = new ArrayList<>();
        this.answer = new ArrayList<>();
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public String getResult() {
        return result;
    }
}
