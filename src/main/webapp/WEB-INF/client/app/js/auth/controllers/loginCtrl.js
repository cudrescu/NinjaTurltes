'use strict';
angular.module('hackathon-app')
	.controller('LoginCtrl', ['$scope','LoginServices', function ($scope,LoginServices) {

		$scope.login = {
			email:'',
			password:''
		}
		$scope.submitLogin = function(){
			LoginServices.login($scope.login).then(function(response){
				console.log(response);
			});
		}

	}]);
