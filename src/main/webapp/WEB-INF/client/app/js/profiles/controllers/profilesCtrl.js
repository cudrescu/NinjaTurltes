'use strict';
angular.module('hackathon-app')
	.controller('ProfilesCtrl', ['$scope','$state', function ($scope,$state) {

		$scope.title = 'Profiles';
		$scope.profiles = [];
		$scope.profilesFilters = {
			pageSize:10,
			pageNumber:1,
			email:'',
			lastName:'',
			firstName:'',
			position:'',
			total:''
		};

		$scope.getProfiles = function(){
			$scope.profiles = [
				{
					id:1,
					email:'email@email.com',
					name:'FirstName LastName',
					position:'Frontend Dev',
					team:'HackIT',
					score:'8.8'
				},
				{
					id:2,
					email:'email@email.com',
					name:'FirstName LastName',
					position:'Frontend Dev',
					team:'HackIT',
					score:'6.4'
				},
				{
					id:3,
					email:'email@email.com',
					name:'FirstName LastName',
					position:'Frontend Dev',
					team:'HackIT',
					score:'5.1'
				},
				{
					id:4,
					email:'email@email.com',
					name:'FirstName LastName',
					position:'Frontend Dev',
					team:'HackIT',
					score:'3.8'
				},
				{
					id:5,
					email:'email@email.com',
					name:'FirstName LastName',
					position:'Frontend Dev',
					team:'HackIT',
					score:'2.8'
				}
			];
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
		}
		$scope.openProfile = function(id){
			$state.go('profile',{id:id});
		}
	}]);
