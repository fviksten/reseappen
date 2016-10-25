package com.sallskapsresan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2016-10-18.
 */

@RestController
public class ContentController {


    @Autowired
    DBRepository dBRepository;


    //recieves, validates and directs new registered users' details to sqlrepository
    @PostMapping("/adduser")
    public ResponseEntity<ReturnData> addUser(@RequestBody @Valid User user, BindingResult bindingResult) throws NoSuchAlgorithmException {
        ReturnData returnData = new ReturnData();
        if (bindingResult.hasErrors()) {
//            returnData.setMessage("Error");
//            returnData.setUser(user);
            System.out.println(bindingResult.toString());
            throw new InvalidInputException("Invalid input", bindingResult);
        }
        else if (!dBRepository.validateUsername(user)) {
            returnData.setMessage("Username already in use");
            returnData.setUser(user);
        }
        else {
            returnData.setMessage("Success");
            dBRepository.addUser(user);
            User sessionUser = dBRepository.getUser(user.getUsername());
            returnData.setUser(sessionUser);
        }
        System.out.println(returnData.getMessage());
        return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ReturnData> authenticateUser(@RequestBody User user, BindingResult bindingResult) throws NoSuchAlgorithmException {
        ReturnData returnData = new ReturnData();
        if (bindingResult.hasErrors()) {
            returnData.setMessage("Error");
            returnData.setUser(user);

        }   else {
//            dBRepository.createPasswords();
            if (dBRepository.validatePassword(user.getUsername(),user.getPassword())) {
                returnData.setMessage("Success");
                User sessionUser = dBRepository.getUser(user.getUsername());
                returnData.setUser(sessionUser);
            } else {
//                returnData.setMessage("Kunde inte logga in!");
//                returnData.setUser(user);
                throw new InvalidPasswordException("Inloggningen misslyckades! Försök igen.");
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


    @PostMapping ("/mySuggestions")
    public ResponseEntity<Destinations> getSuggestionsForUser (@RequestBody User user) throws NoSuchAlgorithmException {
        if (dBRepository.validatePassword(user.getUsername(), user.getPassword())) {
            Destinations suggestions = dBRepository.getSuggestions(user);
            return new ResponseEntity<Destinations>(suggestions, HttpStatus.OK);
        } else {
            return new ResponseEntity<Destinations>(new Destinations(), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/myDestinations")
    public ResponseEntity<ReturnData> submitListOfFavoriteDestinations(@RequestBody MyFavoriteDestinations myFavoriteDestinations) throws NoSuchAlgorithmException {
        User user = myFavoriteDestinations.getUser();
        System.out.println(user.getUserID());
        System.out.println(myFavoriteDestinations.getFavoriteDestinations().get(0));
        System.out.println(user.getPassword());
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
