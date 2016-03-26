'use strict';
angular.module('hackathon-app')
	.controller('LoginCtrl', ['$scope','$state','LoginServices', function ($scope,$state,LoginServices) {

		$scope.login = {
			email:'',
			password:''
		};
		$scope.errors = {
			email:false,
			password:false
		};
		$scope.submitLogin = function(){
			var validate = true;
			$scope.errors.email = false;
			$scope.errors.password = false;
			if($scope.login.email=='' || !validateEmail($scope.login.email)){
				$scope.errors.email = true;
				validate = false;
			}
			if($scope.login.password=='' ){
				$scope.errors.password = true;
				validate = false;
			}
			if(validate){
				LoginServices.login($scope.login).then(function(response){
					if(response.name==$scope.login.email){
						$state.go('dashboard',true);
					}
				},function(data){
					if(data.status==401){
						$scope.errors.email = true;
						$scope.errors.password = true;
					}
				});
			}

		}
		function validateEmail(email) {
			var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			return re.test(email);
		}

	}]);
