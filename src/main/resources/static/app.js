angular.module("app", ["ngRoute", "loginAndRegister.login", "loginAndRegister.register"])
    .config(["$routeProvider", function ($routeProvider) {
        $routeProvider
            .when("/login", {
                templateUrl: "loginAndRegister/angularTemplates/login.template.html",
                // controller: loginController,
                // controllerAs: "vm"
            }).when("/register", {
            templateUrl: "loginAndRegister/angularTemplates/register.template.html",
            controller: loginAndRegister.register.RegisterController,
            controllerAs: "vm"
        }).otherwise("/login");
    }]);
