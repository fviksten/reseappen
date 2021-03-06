/**
 * Created by Administrator on 2016-10-18.
 */
if (!personalTest)
    var personalTest = {};

if (!personalTest.persTest)
    personalTest.persTest = {};


personalTest.persTest.persTestService = function ($http, $rootScope) {

    var index = -1;


    var questions = {
        user: $rootScope.user,

        persForm: [

            {
                questionNbr: 1,
                question: "Do you prefer to focus on the outer world or on your own inner world?",
                options: ["Prefer outer world", "Prefer inner world"],
                answer: ["E", "I"],
                result: ''

            },

            {
                questionNbr: 2,
                question: "Do you prefer to focus on the basic information you take in or do you prefer to interpret and add meaning?",
                options: ["Prefer basic information", "Prefer to interpret and add meaning"],
                answer: ["S", "N"],
                result: ''
            },
            {
                questionNbr: 3,
                question: "Which one of the two statements below describe your personality best?",
                options: ["I prefer to know just a few people well", "I have a wide range of friends and know lots of people"],
                answer: ["I", "E"],
                result: ''
            },
            {
                questionNbr: 4,
                question: "When making decisions, do you prefer to first look at logic and consistency or first look at the people and special circumstances?",
                options: ["Look at logic", "Look at people and circumstances"],
                answer: ["T", "F"],
                result: ''

            },

            {
                questionNbr: 5,
                question: "In dealing with the outside world, do you prefer to get things decided or do you prefer to stay open to new information and options?",
                options: ["Get things decided", "Stay open"],
                answer: ["J", "P"],
                result: ''
            },
            {
                questionNbr: 6,
                question: "Which one of the two statements below describe your personality best?",
                options: ["I am seen as \"outgoing\" or as a \"people person.\"", "I am seen as \"reflective\" or \"reserved.\""],
                answer: ["E", "I"],
                result: ''
            }
        ]
    };


    this.getQuestion = function () {

        console.log(questions.persForm[0].result);
        console.log(questions.persForm[1].result);
        console.log(questions.persForm[2].result);
        console.log(questions.persForm[3].result);
        console.log("new line-----");

        return questions.persForm[++index];
    }
    this.goBackToQuestion = function () {
        return questions.persForm[(--index)];
    }

    this.send = function () {
        console.log("send");
        console.log(questions)
        $http.post("/persTest", questions)
            .then(function (response) {
                $rootScope.user = response.data.user;
                console.log($rootScope.user.personalityType)
            }).finally(function () {
                for (var i = 0; i < questions.persForm.length; i++) {
                questions.persForm[i].result = '';
                    console.log(questions);
            }
                index = -1
            }
        );
    }


    this.logout = function () {
        $rootScope.user = {};
        console.log($rootScope.user);
    }

    this.getQuestions = function () {
        return questions.persForm;
    }

    this.isReadyToSend = function () {
        for (var i = 0; i < questions.persForm.length; i++) {
            if (questions.persForm[i].result.length === 0) {
                return false;
            }
        }
        return true;
    }
}