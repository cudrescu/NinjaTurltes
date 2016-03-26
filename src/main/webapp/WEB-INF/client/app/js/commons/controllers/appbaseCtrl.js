'use strict';
angular.module('hackathon-app')
	.controller('AppbaseCtrl', ['$scope','$state','LoginServices', function ($scope,$state,LoginServices) {

		$scope.logout = function(){
			console.log(2);
			LoginServices.logout().then(function(response){
				$state.go('login',true);
			});
		}

	}]);
