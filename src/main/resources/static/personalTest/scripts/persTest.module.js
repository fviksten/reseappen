angular.module('personalTest.persTest', [])
    .run(function($rootScope) {
        if (!angular.isDefined($rootScope.user)){
            $rootScope.user = localStorage.user;
        }
    })
    .service('persTestService', personalTest.persTest.persTestService)
