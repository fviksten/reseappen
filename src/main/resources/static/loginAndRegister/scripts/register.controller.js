if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.register)
    loginAndRegister.register = {};

loginAndRegister.register.RegisterController = function ($location,$http) {
    var self = this;
    this.addUser = function () {
        this.loading = true;
        $http.post("/adduser",{
            username: this.username,
            firstname: this.firstname,
            lastname: this.lastname,
            email: this.email,
            password: this.password1
        })
            .then(function(response) {
                if (response.data.message === "Success") {
                    $location.path("/login");
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