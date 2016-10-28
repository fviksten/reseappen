if (!personalPage)
    var personalPage = {};

if (!personalPage.persPage)
    personalPage.persPage = {};

personalPage.persPage.personalPageController = function (userService, destinationService, $location) {

    var self = this;

    self.getFavourites = function () {
        destinationService.getFavourites(userService.user)
            .success(function (response) {
                self.object = response; //TAr en stund att ladda
            })
            .error(function (response) {
                userService.user = {};
                $location.path("/error").search({error: response.errors[0].message})
            });
    }

    self.username = userService.user.username;
    self.logout = userService.logout;
    self.suggestions = function () {
        $location.path("/suggestions");
    }

    self.newFavourites = function () {
        self.loading = true;
        destinationService.getDestinations()
            .success(function (response) {
                self.countries = response;
            })
            .error(function (response) {
                userService.user = {};
                $location.path("/error").search({error: response.runtimeErrors[0].message})
            })

        self.loading = false;
    }

    self.addFavourite = function () {
        self.loading = true;
        self.chosenCountries.push(self.aCountry);
        var indexOfAddedItem = self.countries.listDestinations.indexOf(self.aCountry);
        var sendObject = {
            user: userService.user,
            favoriteDestinations: [self.chosenCountries[0].id]
        };
        self.object.listDestinations.push({id: self.chosenCountries[0].id, country: self.aCountry.country});
        destinationService.sendDestinations(sendObject)
        self.loading = false;
    };

    this.setCurrentSlideIndex = function (index) {
         self.currentIndex = index;
        console.log("I setCurrent....")
        console.log(currentIndex);
    }

    this.isCurrentSlideIndex = function (index) {
        return currentIndex === index;

    };

    var myInterval = 3000;
    var object;
    var countries;
    this.chosenCountries = [];
    var currentIndex = 0;
    var selectFavourites = false;
    self.loading = false;
    self.chosenCountries = [];
}
