package com.sallskapsresan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-10-18.
 */

@RestController
public class ContentController {


    @Autowired
    DBRepository dBRepository;


    //recieves, validates and directs new registered users' details to sqlrepository
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

    @PostMapping("/persTest")
    public ResponseEntity<ReturnData> getPersonalityTestAnswers(@RequestBody Questions questions) {
        User sessionUser = questions.getUser();
        dBRepository.setPersonalityType(sessionUser);
        ReturnData returnData = new ReturnData();
        returnData.setUser(sessionUser);
        returnData.setMessage("OK");
        return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
    }

    @GetMapping("/myDestinations")
    public Destinations getListOfDestinations() {
        Destinations destinations = dBRepository.getListOfDestinations();
        return destinations;
    }

    @PostMapping("/mySuggestions")
    public ResponseEntity<Destinations> getSuggestionsForUser(@RequestBody User user) {
        User sessionUser = dBRepository.getUser(user.getUsername());
        Destinations suggestions = dBRepository.getSuggestions(sessionUser);
        return new ResponseEntity<Destinations>(suggestions, HttpStatus.OK);
    }

    @PostMapping("/myDestinations")
    public ResponseEntity<ReturnData> submitListOfFavoriteDestinations(@RequestBody MyFavoriteDestinations myFavoriteDestinations) {
        User user = dBRepository.getUser(myFavoriteDestinations.getUser().getUsername());
        ReturnData returnData = new ReturnData();
        boolean favorite = true;
        dBRepository.insertFavoritesForUser(user.getUserID(), myFavoriteDestinations.getFavoriteDestinations(), favorite);
        returnData.setUser(user);
        returnData.setMessage("OK");
        return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
    }

    @PostMapping("/myFavourites")
    public Destinations getListOfFavourites(@RequestBody User user){
        User sessionUser = dBRepository.getUser(user.getUsername());
        Destinations destinations = dBRepository.getListOfFavourites(sessionUser);
        return destinations;
    }
}
