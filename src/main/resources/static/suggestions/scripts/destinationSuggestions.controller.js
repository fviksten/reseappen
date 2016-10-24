if(!suggestions)
    var suggestions = {};

if(!suggestions.destinationSuggestions)
    suggestions.destinationSuggestions = {};

suggestions.destinationSuggestions.destinationSuggestionsController = function(destinationSuggestionsService, $location, $http, $rootScope) {
    var self = this;


    this.getObjectTemp = function () {
        this.object = destinationSuggestionsService.getObjectTemp();
        console.log(this.object)
    };
    this.getObject = function () {
        console.log('ready to sent HTTPGetObject');
        console.log($rootScope.user);
        $http.get("/mySuggestions",$rootScope.user).then(function (response) {
                self.object = response.data;
                console.log(self.object);
                console.log('inside http get...');
                // return self.object;
            });
    }
    this.object;
    this.user;
    this.errorMessage;
}


