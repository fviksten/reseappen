if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.login)
    loginAndRegister.login = {};


loginAndRegister.login.LoginController = function ($http,$location,$rootScope) {
    var self = this;
    this.login = function () {
        self.loading = true;
        $http.post("/authenticate", {
            username : self.username,
            password : self.password
        })
            .then(function(response) {
                console.log(response);
                if (response.data.message == "Success") {
                    console.log(response);
                    $rootScope.user = response.data.user;
                    $rootScope.user.password = self.password;
                    self.showErrorMessage = true;
                    self.errorMessage = "Success!";
                    console.log($rootScope.user);
                    $location.path("/perstest")
                }
                else {
                    self.showErrorMessage = true;
                    self.errorMessage = "Denied!";
                    $location.path("/login")
                }
            }).finally(function() {
            self.loading = false;
        });
    }
    this.username;
    this.password;
    this.errorMessage;
    this.showErrorMessage = false;
    this.loading = false;
}