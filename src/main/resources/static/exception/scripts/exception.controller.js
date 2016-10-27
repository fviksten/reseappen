/**
 * Created by Administrator on 2016-10-27.
 */
if(!exception)
    var exception = {};

if(!exception.exception)
    exception.exception = {};

exception.exception.exceptionController = function(exceptionService, $location, $http, $rootScope, $routeParams) {
    var self = this;

    this.getObject = function () {
        console.log("....")
        var paramValue = $location.search().error;
        console.log(paramValue);
        console.log("------")

        console.log($routeParams.param1);
        var param1 = $routeParams.param1;
        self.object = paramValue;

    }

    this.object;

}