if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.login)
    loginAndRegister.login = {};


loginAndRegister.login.LoginController = function ($http, $location, $rootScope, userService) {
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
        userService.authenticate(self.credentials, function () {
            if (userService.authenticated) {
                $location.path("/personalpage")
                self.error = false;
            } else {
                $location.path("/login");
                self.error = true;
            }
            self.loading = false;

        })
    }

    self.logout = userService.logout
    self.credentials = {};
    self.loading = false;
}