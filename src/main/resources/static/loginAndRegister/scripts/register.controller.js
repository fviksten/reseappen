if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.register)
    loginAndRegister.register = {};

loginAndRegister.register.RegisterController = function ($location,$http,$rootScope) {
    var self = this;
    this.addUser = function () {
        this.loading = true;
        $http.post("/adduser",{
            username: self.username,
            firstname: self.firstname,
            lastname: self.lastname,
            email: self.email,
            password: self.password1
        })
            .then(function(response) {
                if (response.data.message === "Success") {
                    $rootScope.user = response.data.user;
                    $rootsScope.user.password = self.password;
                    $location.path("/perstest");
                }
                else {
                    self.errorMessage = "något gick fel: " + response.data.message;
                    self.showErrorMessage = true;
                }
            })
        this.loading = false;
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