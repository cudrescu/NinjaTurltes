'use strict';
angular.module('hackathon-app')
	.controller('AppbaseCtrl', ['$scope','$state','LoginServices', function ($scope,$state,LoginServices) {

		$scope.logout = function(){
			LoginServices.logout().then(function(response){
				$state.go('login',true);
			});
		}

	}]);
