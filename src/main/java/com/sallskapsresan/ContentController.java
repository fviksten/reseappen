package com.sallskapsresan;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016-10-18.
 */

@RestController
public class ContentController {

    @PostMapping("/adduser")
    public void addUser(@RequestBody User user) {
        System.out.println(user.getFirstName());
    }
}
