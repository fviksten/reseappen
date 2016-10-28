package com.sallskapsresan;

import com.sallskapsresanExceptionHandling.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sallskapsresanUtils.ReturnData;
import com.sallskapsresanUtils.User;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by Administrator on 2016-10-27.
 */
@RestController
public class AccessController {

    @Autowired
    DBRepository dBRepository;


    @PostMapping("/adduser")
    public ResponseEntity<ReturnData> addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        ReturnData returnData = new ReturnData();
        if (bindingResult.hasErrors()) {
            throw new InvalidInputException("Invalid input", bindingResult);
        }
        else if (!dBRepository.validateUsername(user)) {
            returnData.setMessage("Username already in use");
            returnData.setUser(user);
        } else {
            returnData.setMessage("Success");
            dBRepository.addUser(user);
            User sessionUser = dBRepository.getUser(user.getUsername());
            returnData.setUser(sessionUser);
        }
        return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
    }


    @GetMapping("/authenticate")
    public Principal authenticate(Principal principal) {
        return principal;
    }

}
