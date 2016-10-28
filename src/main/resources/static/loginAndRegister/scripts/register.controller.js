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
                if (response.message === "Success") {
                    userService.authenticate(credentials, function () {
                        if (userService.authenticated) {
                            $location.path("/perstest")
                            self.error = false;
                        } else {
                            self.error = true;
                            $location.path("/login");
                        }
                    })
                } else {
                    self.errorMessage = response.message;
                    self.showErrorMessage = true;
                }
            }).error(function (response) {
            self.errorMessage = "something went wrong!"
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