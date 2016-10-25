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
            $("iframe").attr("src","https://www.google.com/maps/embed/v1/place?key=AIzaSyAjjsG2ur6grCBa1u9UP6etCWnKiR6Uma0&q=" + response.data.listDestinations[0].country )
                // går att kontrollera http-responsen ifall usern är fel.
            });
    }
    this.object;

}


