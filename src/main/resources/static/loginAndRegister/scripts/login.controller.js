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
            .success(function (response) {
                $rootScope.user = response.user;
                $rootScope.user.password = self.password1;
                $location.path("/personalpage");
            }).error(function (response) {
            self.loading = false;
            self.showErrorMessage = true;
            console.log(response)
            self.errorMessage = response.message
        });
    }
    this.username;
    this.password;
    this.errorMessage;
    this.showErrorMessage = false;
    this.loading = false;
}