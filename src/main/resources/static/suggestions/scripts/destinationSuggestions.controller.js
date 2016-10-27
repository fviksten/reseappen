if(!suggestions)
    var suggestions = {};

if(!suggestions.destinationSuggestions)
    suggestions.destinationSuggestions = {};

suggestions.destinationSuggestions.destinationSuggestionsController = function(destinationSuggestionsService,userService, $location, $http, $rootScope) {
    var self = this;

    this.getObject = function () {

        $http.post("/mySuggestions",userService.user).success(function (response) {
                self.object = response;
                // går att kontrollera http-responsen ifall usern är fel.
            }).error(function() {
            console.log("FELFELFEL")
        });
    }
    this.object;

}


