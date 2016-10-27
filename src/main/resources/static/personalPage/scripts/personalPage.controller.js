if(!personalPage)
    var personalPage = {};

if(!personalPage.persPage)
    personalPage.persPage = {};

personalPage.persPage.personalPageController = function (userService,$location) {

    this.logout = userService.logout;
    this.suggestions=function() {
        $location.path("/suggestions");
    }
}


