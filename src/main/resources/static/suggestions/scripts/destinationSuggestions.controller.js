if (!suggestions)
    var suggestions = {};

if (!suggestions.destinationSuggestions)
    suggestions.destinationSuggestions = {};

suggestions.destinationSuggestions.destinationSuggestionsController = function (destinationSuggestionsService, userService, $location, $http, $rootScope) {
    var self = this;

    this.getObject = function () {
        self.loading = true;
        $http.post("/mySuggestions", userService.user).success(function (response) {
            self.object = response;
            self.currentSuggestion = response.listDestinations[self.index];
            if (response.listDestinations[self.index]) {
                $("iframe").attr("src", "https://www.google.com/maps/embed/v1/place?key=AIzaSyAjjsG2ur6grCBa1u9UP6etCWnKiR6Uma0&q=" + self.currentSuggestion.country)
            }
            // går att kontrollera http-responsen ifall usern är fel.
        }).error(function (response) {
            userService.user = {};
            $location.path("/error").search({error : response.runtimeErrors[0].message})
        })
        self.loading = false;
    }

    this.nextSuggestion = function () {
        if (self.index < (self.object.listDestinations.length - 1)) {
            self.index++;
        } else {
            self.index = 0;
        }
        self.currentSuggestion = self.object.listDestinations[self.index];
        $("iframe").attr("src", "https://www.google.com/maps/embed/v1/place?key=AIzaSyAjjsG2ur6grCBa1u9UP6etCWnKiR6Uma0&q=" + self.currentSuggestion.country)
    };

    this.logout = userService.logout;

    this.object;
    this.username = userService.user.username;
    this.currentSuggestion;
    this.loading = false;
    this.index = 0;

}


