if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.login)
    loginAndRegister.login = {};


loginAndRegister.login.LoginController = function ($http,$location,$rootScope) {
    var self = this;
    var usernameInput;
    var passwordInput;

    this.removeRed = function() {
        usernameInput.removeClass('has-error');
        passwordInput.removeClass('has-error');
    };

    this.login = function () {
        self.loading = true;
        $http.post("/authenticate", {
            username : self.username,
            password : self.password
        })
            .success(function (response) {
                $rootScope.user = response.user;
                $rootScope.user.password = self.password;
                $location.path("/personalpage");
            }).error(function (response) {
            self.loading = false;
            self.showErrorMessage = true;
            self.errorMessage = response.message
            usernameInput = angular.element( document.querySelector( '#usernameInput' ) );
            usernameInput.addClass('has-error');
            passwordInput = angular.element( document.querySelector( '#passwordInput' ) );
            passwordInput.addClass('has-error');
        });
    }
    this.username;
    this.password;
    this.errorMessage;
    this.showErrorMessage = false;
    this.loading = false;
}