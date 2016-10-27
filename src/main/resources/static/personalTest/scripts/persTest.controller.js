/**
 * Created by Administrator on 2016-10-18.
 */
if(!personalTest)
    var personalTest = {};

if(!personalTest.persTest)
    personalTest.persTest = {};

personalTest.persTest.persTestController = function(persTestService,userService, $location){

    var self = this;
    this.getQuestion = function(){
        this.questionObj = persTestService.getQuestion();
        self.isReadyToSend = persTestService.isReadyToSend();
    }
    this.goBackToQuestion= function() {
        this.questionObj=persTestService.goBackToQuestion();
        self.isReadyToSend = persTestService.isReadyToSend();
    }

    this.send = function(){
        persTestService.send();
        $location.path("/mydestinations");
    }

    this.logout = userService.logout;

    this.questionObj;

    this.isReadyToSend = false;


}