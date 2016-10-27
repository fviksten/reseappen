if(!personalPage)
    var personalPage = {};

if(!personalPage.persPage)
    personalPage.persPage = {};

personalPage.persPage.personalPageController = function (userService,$location,$http) {

    var self = this;

    this.getFavourites = function () {
        $http.post("/myFavourites", userService.user).then(function (response) {
            self.object = response.data; //TAr en stund att ladda
        });
    }
    this.username = userService.user.username;
    this.logout = userService.logout;
    this.suggestions=function() {
        $location.path("/suggestions");
    }
    this.newFavourites = function () {
        loading = true;
        console.log(" i new favourites");
        $http.get("/myDestinations")
            .then(function (response) {
                self.countries = response.data;
            })
        loading = false;
        console.log(selectFavourites);
        console.log(countries);
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
            .then(function(response) {
                userService.user = response.data.user;
                console.log(userService.user.personalityType)
                $location.path("/personalpage");
            })
            .finally(function () {
                self.loading = false;
            });
    };

    this.setCurrentSlideIndex = function (index) {
         self.currentIndex = index;
        console.log("I setCurrent....")
        console.log(currentIndex);
    }

    this.isCurrentSlideIndex = function (index) {
        return currentIndex === index;

    };
    $scope.prevSlide = function () {
        $scope.currentIndex = ($scope.currentIndex < $scope.slides.length - 1) ? ++$scope.currentIndex : 0;
    };
    $scope.nextSlide = function () {
        $scope.currentIndex = ($scope.currentIndex > 0) ? --$scope.currentIndex : $scope.slides.length - 1;
    };

    var myInterval = 3000;
    var object;
    var countries;
    var selectFavourites=false;
    var loading = false;
    this.chosenCountries = [];
    var currentIndex = 0;

}
