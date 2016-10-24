if(!suggestions)
    var suggestions = {};

if(!suggestions.destinationSuggestions)
    suggestions.destinationSuggestions = {};

suggestions.destinationSuggestions.destinationSuggestionsController = function(destinationSuggestionsService, $location, $http) {
    var self = this;
    this.object;

    this.getObjectTemp = function () {
        this.object = destinationSuggestionsService.getObjectTemp();
        console.log(this.object)
    };
    this.getObject = function () {
        console.log('ready to sent HTTPGetObject');
        $http.get("/suggestionsForMe")
            .then(function (response) {
                self.object = response.data;
                console.log(self.object);
                console.log('inside new http get...');
                return self.object;
            });

    }
}


