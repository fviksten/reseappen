if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.register)
    loginAndRegister.register = {};

loginAndRegister.register.RegisterController = function ($location, $http, $rootScope) {
    var self = this;
    this.addUser = function () {
        self.loading = true;
        $http.post("/adduser", {
            username: self.username,
            firstname: self.firstname,
            lastname: self.lastname,
            email: self.email,
            password: self.password1
        })
            .success(function (response) {
                $rootScope.user = response.data.user;
                $rootScope.user.password = self.password1;
                $location.path("/perstest");
            }).error(function (response) {
            self.loading = false;
            self.errorMessage = response.errorMessage
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