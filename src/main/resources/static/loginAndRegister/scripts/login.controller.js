if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.login)
    loginAndRegister.login = {};


loginAndRegister.login.LoginController = function ($location, userService) {
    var self = this;

    self.usernameInput = angular.element( document.querySelector( '#usernameInput' ) );
    self.passwordInput = angular.element( document.querySelector( '#passwordInput' ) );

    self.removeRed = function() {
            self.usernameInput.removeClass('has-error has-feedback');
            self.passwordInput.removeClass('has-error has-feedback');
            this.showErrorMessage = false;
    };
    

    self.login = function () {
        self.error = false;
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