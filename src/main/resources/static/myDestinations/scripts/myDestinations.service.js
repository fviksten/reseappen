/**
 * Created by Administrator on 2016-10-20.
 */
if(!myDestinations)
    var myDestinations = {};

if(!myDestinations.destinations)
    myDestinations.destinations = {};

myDestinations.destinations.myDestinationsService = function($http){


    this.getObject = function() {

        var object = {answer: "hej"};

        return object;
    }


}