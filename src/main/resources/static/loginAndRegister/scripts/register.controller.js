if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.register)
    loginAndRegister.register = {};

loginAndRegister.register.RegisterController = function ($location, $http, $rootScope, userService) {
    var self = this;


    self.addUser = function () {
        self.loading = true;
        var userDetails = {
            username: self.username,
            firstname: self.firstname,
            lastname: self.lastname,
            email: self.email,
            password: self.password1
        }
        userService.addUser(userDetails)
            .success(function (response) {
                var credentials = {
                    username: userDetails.username,
                    password: userDetails.password
                }
                userService.authenticate(credentials, function () {
                    if (userService.authenticated) {
                        $location.path("/perstest")
                        self.error = false;
                    } else {
                        $location.path("/login");
                        self.error = true;
                    }
                })
            }).error(function () {
            self.errorMessage = "Something went wrong: " + response.data.message;
            self.showErrorMessage = true;
        }).finally(function () {
            self.loading = false;
        });
    };

    this.username;
    this.firstname;
    this.lastname;
    this.email;
    this.password1;
    this.password2;
    this.loading = false;
    this.errorMessage;
    this.showErrorMessage = false;
};