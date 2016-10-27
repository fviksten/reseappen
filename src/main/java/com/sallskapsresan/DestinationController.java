package com.sallskapsresan;

import com.sallskapsresanDestinations.MyFavoriteDestinations;
import com.sallskapsresanDestinations.Destinations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sallskapsresanUtils.ReturnData;
import com.sallskapsresanUtils.User;

/**
 * Created by Administrator on 2016-10-18.
 */

@RestController
public class DestinationController {


    @Autowired
    DBRepository dBRepository;


    //recieves, validates and directs new registered users' details to sqlrepository

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
