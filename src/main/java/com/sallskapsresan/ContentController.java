package com.sallskapsresan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Administrator on 2016-10-18.
 */

@RestController
public class ContentController {

    @Autowired
    DBRepository dBRepository;


    //recieves, validates and directs new registered users' details to sqlrepository
    @PostMapping("/adduser")
    public ResponseEntity<ReturnData> addUser(@RequestBody @Valid User user, BindingResult bindingResult, HttpSession session) {
        ReturnData returnData = new ReturnData();
        if (bindingResult.hasErrors()) {
            returnData.setMessage("Error");
            returnData.setUser(user);
        } else {
            returnData.setMessage("Success");
            dBRepository.addUser(user);
            User sessionUser = dBRepository.getUser(user.getUsername());
            returnData.setUser(sessionUser);
            session.setAttribute("user",sessionUser);
        }
        return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ReturnData> authenticateUser(@RequestBody User user, BindingResult bindingResult, HttpSession session) {
        ReturnData returnData = new ReturnData();
        if (bindingResult.hasErrors()) {
            returnData.setMessage("Error");
            returnData.setUser(user);
        }   else {
            if (dBRepository.validatePassword(user.getUsername(),user.getPassword())) {
                returnData.setMessage("Success");
                User sessionUser = dBRepository.getUser(user.getUsername());
                returnData.setUser(sessionUser);
                session.setAttribute("user", sessionUser);
            } else {
                returnData.setMessage("Kunde inte logga in!");
                returnData.setUser(user);
            }
        }
        return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
    }

//    @PostMapping("/persTest")
//    public ResponseEntity<HttpStatus> recievePersTest (@RequestBody String jsonLine) {
//        Answer answer = new Answer();
//        String output = answer.setType(jsonLine).name();
//        System.out.println(output);
//
//        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//    }

    @PostMapping("/persTest")
    public ResponseEntity<HttpStatus> getPersonalityTestAnswers(@RequestBody Questions questions) {
        for (Question question : questions.getPersForm()) {
            System.out.println(question.getResult());
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

}
