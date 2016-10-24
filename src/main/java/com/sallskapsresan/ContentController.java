package com.sallskapsresan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<ReturnData> addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        ReturnData returnData = new ReturnData();
        if (bindingResult.hasErrors()) {
            returnData.setMessage("Error");
            returnData.setUser(user);
        }
        else if (!dBRepository.validateUser(user)) {
            returnData.setMessage("Username already in use");
            returnData.setUser(user);
        }
        else {
            returnData.setMessage("Success");
            dBRepository.addUser(user);
            User sessionUser = dBRepository.getUser(user.getUsername());
            returnData.setUser(sessionUser);
        }
        return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ReturnData> authenticateUser(@RequestBody User user, BindingResult bindingResult) {
        ReturnData returnData = new ReturnData();
        if (bindingResult.hasErrors()) {
            returnData.setMessage("Error");
            returnData.setUser(user);
        }   else {
            if (dBRepository.validatePassword(user.getUsername(),user.getPassword())) {
                returnData.setMessage("Success");
                User sessionUser = dBRepository.getUser(user.getUsername());
                System.out.println(sessionUser.getUserID());
                returnData.setUser(sessionUser);
            } else {
                returnData.setMessage("Kunde inte logga in!");
                returnData.setUser(user);
            }
        }
        return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
    }

    @PostMapping("/persTest")
    public ResponseEntity<ReturnData> getPersonalityTestAnswers(@RequestBody Questions questions) {
        User sessionUser = questions.getUser();
        dBRepository.setPersonalityType(sessionUser);
        ReturnData returnData = new ReturnData();
        returnData.setUser(sessionUser);
        returnData.setMessage("OK");
        return new ResponseEntity<ReturnData>(returnData,HttpStatus.OK);
    }

    @GetMapping("/myDestinations")
    public Destinations getListOfDestinations(){
        Destinations destinations = dBRepository.getListOfDestinations();
        return destinations;
    }

    @GetMapping ("/mySuggestions")
    public ResponseEntity<Destinations> getSuggestionsForUser (@RequestBody User user) {
        System.out.println("I contentController men innan anrop till repository");

            Destinations suggestions = dBRepository.getSuggestions(user);
            System.out.println("I contentController efter .getSuggestions");
            return new ResponseEntity<Destinations>(suggestions, HttpStatus.OK);


    }

    @PostMapping("/myDestinations")
    public ResponseEntity<ReturnData> submitListOfFavoriteDestinations(@RequestBody MyFavoriteDestinations myFavoriteDestinations) {
        User user = myFavoriteDestinations.getUser();
        System.out.println(user.getUserID());
        System.out.println(myFavoriteDestinations.getFavoriteDestinations().get(0));
        ReturnData returnData = new ReturnData();
        if (dBRepository.validatePassword(user.getUsername(), user.getPassword())){
            boolean favorite = true;
            dBRepository.insertFavoritesForUser(user.getUserID(), myFavoriteDestinations.getFavoriteDestinations(), favorite);
            returnData.setUser(user);
            returnData.setMessage("OK");
        }
        else {
            returnData.setUser(user);
            returnData.setMessage("Något gick fel");
        }
        return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
    }
}
