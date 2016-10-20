/**
 * Created by Administrator on 2016-10-20.
 */
if(!myDestinations)
    var myDestinations = {};

if(!myDestinations.destinations)
    myDestinations.destinations = {};

myDestinations.destinations.myDestinationsController = function(myDestinationsService, $location, $http){

    var self = this;

    this.getObject = function(){

        $http.get("/myDestinations")
            .then(function(response) {
                self.object = response.data;
                console.log(self.object);
                console.log('inside new http get...');
                // return object;
            });

    }

    this.send = function(){
        persTestService.send();
        $location.path("/login");
    }

    this.object;
}

