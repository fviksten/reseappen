if(!personalPage)
    var personalPage = {};

if(!personalPage.persPage)
    personalPage.persPage = {};

personalPage.persPage.personalPageController = function ($rootScope,$location) {
    this.user = $rootScope.user;
    this.logout = function() {
        $rootScope.user = {};
        $location.path("/login");
    }
}

