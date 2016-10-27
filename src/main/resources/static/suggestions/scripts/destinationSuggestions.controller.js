if(!suggestions)
    var suggestions = {};

if(!suggestions.destinationSuggestions)
    suggestions.destinationSuggestions = {};

suggestions.destinationSuggestions.destinationSuggestionsController = function(destinationSuggestionsService, $location, $http, $rootScope) {
    var self = this;

    this.getObject = function () {
        self.loading = true;
        $http.post("/mySuggestions", $rootScope.user).success(function (response) {
            self.object = response;
            self.currentSuggestion = response.listDestinations[self.index];
            if (response.listDestinations[self.index]) {
                $("iframe").attr("src", "https://www.google.com/maps/embed/v1/place?key=AIzaSyAjjsG2ur6grCBa1u9UP6etCWnKiR6Uma0&q=" + response.listDestinations[self.index].country)
            }
            // går att kontrollera http-responsen ifall usern är fel.
        }).error(function (response) {
            $rootScope.user = {};
            $location.path("/error").search({error:response.runtimeErrors[0].message});;
        });
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

    this.logout = function() {
        $rootScope.user = {};
        $location.path("/login");
    }

    this.object;

    this.currentSuggestion;
    this.loading=false;
    this.index=0;

}


