package com.sallskapsresan;

import com.sallskapsresanPersonalTest.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sallskapsresanUtils.ReturnData;
import com.sallskapsresanUtils.User;

/**
 * Created by Administrator on 2016-10-27.
 */
@RestController
public class PersonalTestController {

    @Autowired
    DBRepository dBRepository;


    @PostMapping("/persTest")
    public ResponseEntity<ReturnData> getPersonalityTestAnswers(@RequestBody Questions questions) {
        User sessionUser = questions.getUser();
        dBRepository.setPersonalityType(sessionUser);
        ReturnData returnData = new ReturnData();
        returnData.setUser(sessionUser);
        returnData.setMessage("OK");
        return new ResponseEntity<ReturnData>(returnData, HttpStatus.OK);
    }
}
