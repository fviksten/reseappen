/**
 * Created by Administrator on 2016-10-18.
 */
if(!personalTest)
    var personalTest = {};

if(!personalTest.persTest)
    personalTest.persTest = {};



personalTest.persTest.persTestService = function($http){

    var index = 0;


    var questions = {persForm:[

        {
          question: "1) Do you prefer to focus on the outer world or on your own inner world?",
            options: ["Prefer outer world", "Prefer inner world"],
            answer: ["E", "I"],
            result:''
        },

        {
            question: "2) Do you prefer to focus on the basic information you take in or do you prefer to interpret and add meaning?",
            options: ["Prefer basic information", "Prefer to interpret and add meaning"],
            answer: ["S", "N"],
            result:''
        },

        {
            question: "3) When making decisions, do you prefer to first look at logic and consistency or first look at the people and special circumstances?",
            options: ["Look at logic", "Look at people and circumstances"],
            answer : ["T","F"],
            result:''
        },

        {
            question: "4) In dealing with the outside world, do you prefer to get things decided or do you prefer to stay open to new information and options?",
            options: ["Get things decided", "Stay open"],
            answer : ["J","P"],
            result:''
        }

    ]};



    this.getQuestion = function(){

        // if(index > 0){
        //     alert(resultz);
        //     console.log(resultz);
        // }
        console.log(questions.persForm[0].result);
        console.log(questions.persForm[1].result);
        console.log(questions.persForm[2].result);
        console.log(questions.persForm[3].result);
        console.log("new line-----");

        return questions.persForm[index++];
    }
    this.send = function(){
        console.log("send");
        console.log( questions)
        $http.post("/persTest",questions);
    }

}