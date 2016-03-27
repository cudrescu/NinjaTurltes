'use strict';
angular.module('hackathon-app')
	.controller('AppbaseCtrl', ['$scope','$state','LoginServices', function ($scope,$state,LoginServices) {

		$scope.logout = function(){
			LoginServices.logout().then(function(response){
				$state.go('login',true);
			});
		}
		$scope.myTeamSidebar = false;
		$scope.profilesSelected = [];
		$scope.addProfileToSelection = function(x){
			var found = false;
      angular.forEach($scope.profilesSelected, function(value, key) {
        if(value.email==x.email){
          found = true;
        }
      });
			if(!found){
				var y = angular.copy(x);
				y.selected = false;
				$scope.profilesSelected.push(y);
			}

		};
		$scope.selectProfileToTeam = function(x){
			console.log(x);
			x.selected = true;
		};
		$scope.removeProfileFromTeam = function(x){
			console.log(x);
			x.selected = false;
		};
		$scope.removeProfileFromSelection = function(x){
			var y = $scope.profilesSelected.indexOf(x);
			if(y>=0){
				$scope.profilesSelected.splice(y,1);
			}
		};
	}]);
