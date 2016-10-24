if(!suggestions)
    var suggestions = {};

if(!suggestions.destinationSuggestions)
    suggestions.destinationSuggestions = {};

suggestions.destinationSuggestions.destinationSuggestionsService = function ($http, $rootScope) {
    this.getObjectTemp = function() {
        console.log("nu är vi i getObject i service"); //Ska bort

        var object = {destinations: [
            { id: 1,
            country: 'Norge'
            },
            { id: 2,
                country: 'Zambia'
            },
            { id: 3,
                country: 'Uruguay'
            }
        ]}
        // console.log(object.destinations); //Ska bort
        return object;
    }
}
