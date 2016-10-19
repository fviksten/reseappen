package com.sallskapsresan;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016-10-18.
 */

@RestController
public class ContentController {


    //recieves, validates and directs new registered users' details to sqlrepository
    @PostMapping("/adduser")
    public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {
        System.out.println(user.getFirstname());
        System.out.println(user.getLastname());
        System.out.println(user.getUsername());
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
