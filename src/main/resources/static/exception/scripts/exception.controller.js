/**
 * Created by Administrator on 2016-10-27.
 */
if(!exception)
    var exception = {};

if(!exception.exception)
    exception.exception = {};

exception.exception.exceptionController = function(userService, $location, $routeParams) {
    var self = this;

    this.getObject = function (userService) {
        var paramValue = $location.search().error;
        var param1 = $routeParams.param1;
        self.object = paramValue;

    }

    this.object;
    this.logout = userService.logout;


}