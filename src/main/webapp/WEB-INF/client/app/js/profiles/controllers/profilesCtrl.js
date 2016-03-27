'use strict';
angular.module('hackathon-app')
	.controller('ProfilesCtrl', ['$scope','$state', 'positions', 'ProfilesServices', function ($scope, $state, positions, ProfilesServices) {

		$scope.title = 'Profiles';
		$scope.profiles = [];
		$scope.positions = positions;
		$scope.profilesFilters = {
			pageSize:15,
			pageNumber:1,
			email:'',
			lastName:'',
			firstName:''
		};
		$scope.profilePageInfo = {
			total:0,
			totalPages:1
		};
		$scope.changePage = function(x){
			if(x>0 && x<=$scope.profilePageInfo.totalPages){
				$scope.profilesFilters.pageNumber = x;
				$scope.getProfiles();
			}
		};
		$scope.getProfiles = function(){
			$scope.profilesFilters.firstName = $scope.profilesFilters.lastName;
			ProfilesServices.getList($scope.profilesFilters).then(function(response){
				$scope.profiles = response.items;
				$scope.profilePageInfo.total = response.totalItems;
				$scope.profilePageInfo.totalPages = parseInt(response.totalItems/$scope.profilesFilters.pageSize + 1);
			});
		};
		$scope.getProfiles();
		$scope.scoreBadgeCollor = function(x){
			if(x>8){
				return 'bg-green';
			}
			if(x>6){
				return 'bg-light-blue';
			}
			if(x>4){
				return 'bg-yellow';
			}
			return 'bg-red';
		};
	}]);
