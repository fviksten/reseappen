angular.module("app", ["ngRoute", "loginAndRegister.login", "loginAndRegister.register", "personalTest.persTest", "myDestinations.destinations", "suggestions.destinationSuggestions", "exception.exception", "ui.bootstrap"])
    .service("userService", userService)
    .service("destinationService", destinationService)
    .config(["$routeProvider", "$httpProvider", function ($routeProvider, $httpProvider) {
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
        }).when("/personalpage", {
                templateUrl: "personalPage/angularTemplates/personalPage.template.html",
                controller: personalPage.persPage.personalPageController,
                controllerAs: "vm"
            }
        ).when("/suggestions", {
                templateUrl: "suggestions/angularTemplates/destinationSuggestions.template.html",
                controller: suggestions.destinationSuggestions.destinationSuggestionsController,
                controllerAs: "vm"
            }
        ).when("/error", {
                templateUrl: "exception/angularTemplates/exception.template.html",
                controller: exception.exception.exceptionController,
                controllerAs: "vm"
            }
        ).otherwise("/login");
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    }]);

