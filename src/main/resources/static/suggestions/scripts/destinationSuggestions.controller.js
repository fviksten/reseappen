if(!suggestions)
    var suggestions = {};

if(!suggestions.destinationSuggestions)
    suggestions.destinationSuggestions = {};

suggestions.destinationSuggestions.destinationSuggestionsController = function(destinationSuggestionsService, $location, $http, $rootScope) {
    var self = this;

    this.getObject = function () {
        self.loading=true;
        $http.post("/mySuggestions",$rootScope.user).then(function (response) {
                self.object = response.data;
            self.currentSuggestion=response.data.listDestinations[self.index];
            $("iframe").attr("src","https://www.google.com/maps/embed/v1/place?key=AIzaSyAjjsG2ur6grCBa1u9UP6etCWnKiR6Uma0&q=" + response.data.listDestinations[0].country )
                // går att kontrollera http-responsen ifall usern är fel.
            });
        self.loading=false;
    }

    this.nextSuggestion=function() {
        if (self.index<(self.object.listDestinations.length-1)){
            self.index++;
        } else{self.index=0;}
        self.currentSuggestion=self.object.listDestinations[self.index];
    };

    this.object;

    this.currentSuggestion;
    this.loading=false;
    this.index=0;
    this.mapurl = "https://www.google.com/maps/embed/v1/place?key=&q=Space+Needle,Seattle+WA"

}


