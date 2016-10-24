if(!suggestions)
    var suggestions = {};

if(!suggestions.destinationSuggestions)
    suggestions.destinationSuggestions = {};

suggestions.destinationSuggestions.destinationSuggestionsController = function(destinationSuggestionsService, $location, $http, $rootScope) {
    var self = this;

    this.getObject = function () {

        console.log($rootScope.user);
        $http.post("/mySuggestions",$rootScope.user).then(function (response) {
                self.object = response.data;
                // går att kontrollera http-responsen ifall usern är fel.
            });
    }
    this.object;

}


