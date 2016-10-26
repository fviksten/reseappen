if(!personalPage)
    var personalPage = {};

if(!personalPage.persPage)
    personalPage.persPage = {};

personalPage.persPage.personalPageController = function ($rootScope,$location, $http) {
    var self=this;

    this.getFavourites=function(){
        $http.post("/myFavourites", $rootScope.user).then(function (response) {
            self.object = response.data;
        });
    }

    this.logout = function () {
        $rootScope.user = {};
        $location.path("/login");
    }
    this.suggestions = function () {
        $location.path("/suggestions");
    }
 var object;
}
