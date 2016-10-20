angular.module("app", ["ngRoute", "loginAndRegister.login", "loginAndRegister.register", "personalTest.persTest", "myDestinations.destinations"])
    .run(function($rootScope) {
        $rootScope.user ={};
    })
    .config(["$routeProvider", function ($routeProvider) {
        $routeProvider
            .when("/login", {
                templateUrl: "loginAndRegister/angularTemplates/login.template.html",
                controller: loginAndRegister.login.LoginController,
                controllerAs: "vm"
            }).when("/register", {
            templateUrl: "loginAndRegister/angularTemplates/register.template.html",
            controller: loginAndRegister.register.RegisterController,
            controllerAs: "vm"
        }).when("/perstest", {
            templateUrl: "personalTest/angularTemplates/persTest.template.html",
            controller: personalTest.persTest.persTestController,
            controllerAs: "vm"
        }).when("/mydestinations", {
            templateUrl: "myDestinations/angularTemplates/myDestinations.template.html",
            controller: myDestinations.destinations.myDestinationsController,
            controllerAs: "vm"
        }).otherwise("/login");
    }]);
