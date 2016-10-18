angular.module("loginAndRegister", ["ngRoute","loginAndRegister.login","loginAndRegister.register"])
    .config(["$routeProvider",function($routeProvider) {
        $routeProvider
            .when("/login",{
                templateUrl : "/src/main/resources/static/loginAndRegister/angularTemplates/login.template.html",
                controller : academy.spotify.SpotifyController,
                controllerAs : "vm"
            }).when("/register",{
            templateUrl : "/src/main/resources/static/loginAndRegister/angularTemplates/register.template.html",
            controller : academy.insults.InsultsController,
            controllerAs : "vm"
        }).otherwise("/spotify");
    }]);
