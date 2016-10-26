if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.login)
    loginAndRegister.login = {};


loginAndRegister.login.LoginController = function ($http,$location,$rootScope) {
    var self = this;
    this.usernameInput = angular.element( document.querySelector( '#usernameInput' ) );
    this.passwordInput = angular.element( document.querySelector( '#passwordInput' ) );

    this.removeRed = function() {
            self.usernameInput.removeClass('has-error has-feedback');
            self.passwordInput.removeClass('has-error has-feedback');
            this.showErrorMessage = false;
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
            self.errorMessage = response.runtimeErrors[0].message;
            self.usernameInput.addClass('has-error has-feedback');
            self.passwordInput.addClass('has-error has-feedback');
        });
    }
    this.username;
    this.password;
    this.errorMessage;
    this.showErrorMessage = false;
    this.loading = false;
}