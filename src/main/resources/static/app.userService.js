

userService = function ($http,$location) {
    var self = this;

    self.user = {}
    self.authenticated

    self.logout = function () {
        $http.post("/logout").finally(function () {
            self.authenticated = false;
            self.user = {};
            $location.path("/");
        });
    }
    self.authenticate = function (credentials, callback) {
        var headers = credentials ? {
            authorization: "Basic "
            + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('/authenticate', {headers: headers})
            .success(function (response) {
                if (response.name) {
                    self.authenticated = true;
                    self.user.username = response.name;
                } else {
                    self.authenticated = false;
                }
                callback && callback();
            }).error(function () {
            self.authenticated = false;
            callback && callback();
        });
    }
}
