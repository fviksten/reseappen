if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.login)
    loginAndRegister.login = {};


loginAndRegister.login.LoginController = function ($http) {
    var self = this;
    this.login = function () {
        $http.post("/authenticate", {
            username : this.username,
            password : this.password
        })
            .then(function(response) {
                console.log(response);
                if (response.status == 200) {
                    self.showErrorMessage = true;
                    self.errorMessage = "Sucess!";
                }
                else {
                    self.showErrorMessage = true;
                    self.errorMessage = "DEnied!";
                }
            });
    }
    this.username;
    this.password;
    this.errorMessage;
    this.showErrorMessage = false;
}