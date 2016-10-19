package com.sallskapsresan;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Administrator on 2016-10-18.
 */

@RestController
public class ContentController {


    //recieves, validates and directs new registered users' details to sqlrepository
    @PostMapping("/adduser")
    public ResponseEntity<Message> addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        Message message = new Message();
        if (bindingResult.hasErrors()) {
            message.setMessage("Error");
            return new ResponseEntity<Message>(message, HttpStatus.OK);
        } else {
            message.setMessage("Success");
            return new ResponseEntity<Message>(message, HttpStatus.OK);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Message> authenticateUser(@RequestBody User user,BindingResult bindingResult) {
        Message message = new Message();
        if (bindingResult.hasErrors()) {
            message.setMessage("Error");
            return new ResponseEntity<Message>(message, HttpStatus.OK);
        }   else {
            message.setMessage("Success");
            return new ResponseEntity<Message>(message, HttpStatus.OK);
        }
    }
}