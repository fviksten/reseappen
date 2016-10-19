package com.sallskapsresan;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<String> addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<String>("Invalid information!", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Everything went fine!", HttpStatus.OK);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<HttpStatus> authenticateUser(@RequestBody User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}