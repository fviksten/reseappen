if (!suggestions)
    var suggestions = {};

if (!suggestions.destinationSuggestions)
    suggestions.destinationSuggestions = {};

suggestions.destinationSuggestions.destinationSuggestionsController = function (destinationService, userService) {
    var self = this;

    this.getObject = function () {
        self.loading = true;
        destinationService.getObject(userService.user, function(response) {
            self.object = response;
            self.currentSuggestion = response.listDestinations[self.index];
            if (response.listDestinations[self.index]) {
                $("iframe").attr("src", "https://www.google.com/maps/embed/v1/place?key=AIzaSyAjjsG2ur6grCBa1u9UP6etCWnKiR6Uma0&q=" + self.currentSuggestion.country)
            }
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


