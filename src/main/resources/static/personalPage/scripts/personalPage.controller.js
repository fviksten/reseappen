if(!personalPage)
    var personalPage = {};

if(!personalPage.persPage)
    personalPage.persPage = {};

personalPage.persPage.personalPageController = function ($rootScope,$location) {

    this.logout = function() {
        $rootScope.user = {};
        $location.path("/login");
    }
    this.suggestions=function() {
        $location.path("/suggestions");
    }
}


