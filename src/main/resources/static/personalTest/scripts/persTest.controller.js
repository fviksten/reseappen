/**
 * Created by Administrator on 2016-10-18.
 */
if(!personalTest)
    var personalTest = {};

if(!personalTest.persTest)
    personalTest.persTest = {};

personalTest.persTest.persTestController = function(persTestService, $location){

    this.getQuestion = function(){
        this.questionObj = persTestService.getQuestion();
    }
    this.goBackToQuestion= function() {
        this.questionObj=persTestService.goBackToQuestion();
    }

    this.send = function(){
        persTestService.send();
        $location.path("/login");
    }

    this.logout = function() {
        persTestService.logout();
        $location.path("/login");
    }

    this.questionObj;


}