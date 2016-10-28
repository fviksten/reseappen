destinationService = function ($http, userService, $location) {

    var self = this;

    self.getDestinations = function () {
        return $http.get("/myDestinations");
    }

    self.sendDestinations = function (sendObject) {
        $http.post("/myDestinations", sendObject)
            .success(function (response) {
                userService.user = response.user;
                $location.path("/personalpage");
            }).error(function (response) {
            userService.user = {};
            $location.path("/error").search({error: response.errors[0].message})
        })
    }

    self.getFavourites = function (user) {
        return $http.post("/myFavourites", user);
    }

    self.getObject = function (user, successCallback) {
        $http.post("/mySuggestions", user)
            .success(successCallback)
            .error(function (response) {
                userService.user = {};
                $location.path("/error").search({error: response.errors[0].message})
            })
    }
}