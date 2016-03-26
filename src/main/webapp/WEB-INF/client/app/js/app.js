(function () {
    'use strict';

    angular.module('hackathon-app', ['ui.router'])

        .controller('TestController', function($scope) {
            $scope.welcome = "Hello turtles !";

        })

})();