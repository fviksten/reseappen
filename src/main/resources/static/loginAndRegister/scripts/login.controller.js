if (!loginAndRegister)
    var loginAndRegister = {};

if (!loginAndRegister.login)
    loginAndRegister.login = {};


loginAndRegister.login.LoginController = function ($http, $location, $rootScope) {
    var self = this;

    self.login = function () {
        self.loading = true;
        authenticate(self.credentials, function () {
            if ($rootScope.authenticated) {
                $location.path("/personalpage")
                self.error = false;
            } else {
                $location.path("/login");
                self.error = true;
            }
            self.loading = false;

        })
    }

    var self = this

    var authenticate = function (credentials, callback) {
        var headers = credentials ? {
            authorization: "Basic "
            + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('/authenticate', {headers: headers})
            .success(function (response) {
                if (response.name) {
                    $rootScope.authenticated = true;
                    console.log(response.name);
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback();
            })
            .error(function () {
                $rootScope.authenticated = false;
                callback && callback();
            });
    };

    self.logout = function() {
        $http.post('logout', {}).finally(function() {
            $rootScope.authenticated = false;
            $location.path("/");
        });
    }

    authenticate();
    self.credentials = {};
    self.loading = false;
}