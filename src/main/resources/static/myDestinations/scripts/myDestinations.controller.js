/**
 * Created by Administrator on 2016-10-20.
 */
if(!myDestinations)
    var myDestinations = {};

if(!myDestinations.destinations)
    myDestinations.destinations = {};

myDestinations.destinations.myDestinationsController = function(myDestinationsService,userService, $location, $http){


    var self = this;

    this.getObject = function(){

        $http.get("/myDestinations")
            .success(function (response) {
                self.object = response;
                // return object;
            }).error(function (response) {
            userService.user = {};
            $location.path("/error").search({error : response.runtimeErrors[0].message})
        });

    }


    this.send = function(){
        persTestService.send();
        $location.path("/login");
    }

    this.object;


    this.chosenCountries = [];

    var add_button = document.getElementById("addButton");
    var submit_button = document.getElementById("submitButton");

    this.addItemToList = function () {
        self.chosenCountries.push(self.aCountry);
        var indexOfAddedItem = self.object.listDestinations.indexOf(self.aCountry);
        self.object.listDestinations.splice(indexOfAddedItem, 1);
        console.log(self.chosenCountries);
        self.aCountry = this.object.listDestinations[0]; // Resets dropdown list to position 0 after each add
        if (self.chosenCountries.length >= 3) { // Disables add and enables submit after 3 added countries
            add_button.setAttribute("disabled", true);
            submit_button.removeAttribute("disabled");
        }
    };

    this.removeItemFromList = function (listitem) {
        var indexOfItem = self.chosenCountries.indexOf(listitem);
        self.object.listDestinations.push(listitem);
        console.log(listitem);
        if (self.chosenCountries.length >= 3) { // Enables add and disables submit when countries in array no longer are 3
            add_button.removeAttribute("disabled");
            submit_button.setAttribute("disabled", true);
        }
        if (indexOfItem >= 0) {
            self.chosenCountries.splice(indexOfItem, 1);
        }
    };

    this.sendForm = function () {
        var sendObject = {
            user: userService.user,
            favoriteDestinations: [this.chosenCountries[0].id, this.chosenCountries[1].id, this.chosenCountries[2].id]
        };
        self.loading = true;
        console.log(self.chosenCountries);
        console.log("----");
        console.log(sendObject);
        $http.post("/myDestinations",sendObject)
            .success(function (response) {
            userService.user = response.user;
            $location.path("/personalpage");
        }).error(function (response) {
            userService.user = {};
            $location.path("/error").search({error : response.runtimeErrors[0].message})
        })
            .finally(function () {
                self.loading = false;
            });
    };
}

