'use strict';
angular.module('hackathon-app')
    .controller('TeamController', ['$scope', '$modalInstance', function ($scope, $modalInstance) {

        $scope.submit = function() {
            $modalInstance.close($scope.team);
        }

    }]);