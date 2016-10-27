if(!personalPage)
    var personalPage = {};

if(!personalPage.persPage)
    personalPage.persPage = {};

personalPage.persPage.personalPageController = function (userService,$location,$http) {

    var self = this;

    this.getFavourites = function () {
        $http.post("/myFavourites", userService.user).success(function (response) {
            self.object = response; //TAr en stund att ladda
        }).error(function (response) {
            userService.user = {};
            $location.path("/error").search({error : response.errors[0].message})
        });
    }

    this.username = userService.user.username;
    this.logout = userService.logout;
    this.suggestions=function() {
        $location.path("/suggestions");
    }
    this.newFavourites = function () {
        loading = true;
        $http.get("/myDestinations")
            .success(function (response) {
                self.countries = response;
            }).error(function (response) {
            userService.user = {};
            $location.path("/error").search({error : response.errors[0].message})
        });
        loading = false;
    }

    this.addFavourite= function(){
        self.chosenCountries.push(self.aCountry);
        var indexOfAddedItem = self.countries.listDestinations.indexOf(self.aCountry);
        var sendObject = {
            user: userService.user,
            favoriteDestinations: [self.chosenCountries[0].id]
        };
        self.object.listDestinations.push({id: self.chosenCountries[0].id, country : self.aCountry.country});

        $http.post("/myDestinations",sendObject)
            .success(function (response) {
                userService.user = response.user;
                $location.path("/personalpage");
            }).error(function (response) {
                userService.user = {};
                $location.path("/error").search({error : response.errors[0].message})
            })
            .finally(function () {
                self.loading = false;
            });
    };

    var object;
    var countries;
    var selectFavourites=false;
    var loading = false;
    this.chosenCountries = [];
}
