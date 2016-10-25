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
            });
    }

    this.like=function() {

    }
    this.object;

}


