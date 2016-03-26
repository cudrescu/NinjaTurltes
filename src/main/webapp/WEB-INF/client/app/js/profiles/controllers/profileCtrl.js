'use strict';
angular.module('hackathon-app')
	.controller('ProfileCtrl', ['$scope','$state', function ($scope,$state) {

		$scope.profile = {
			id:1,
			email:'email@email.com',
			name:'FirstName LastName',
			position:'Frontend Dev',
			team:'HackIT',
			score:'8.8',
			technologies:[
				{
					name:'Technical skils',
					skils:[
						{
							name:'Java',
							score:'8.3'
						},
						{
							name:'PHP',
							score:'2.1'
						},
						{
							name:'Javascript',
							score:'6.5'
						},
						{
							name:'Ruby',
							score:'0.3'
						},
						{
							name:'MySQL',
							score:'4.8'
						}
					]
				},
				{
					name:'Comunication skils',
					skils:[
						{
							name:'Open mindid',
							score:'8.3'
						},
						{
							name:'Solving conflicts',
							score:'2.1'
						},
						{
							name:'Assigning tasks',
							score:'6.5'
						},
						{
							name:'Team comunication',
							score:'0.3'
						},
						{
							name:'Team cooperation',
							score:'4.8'
						}
					]
				}
			]
		};

		$scope.getProfile = function(){
			$scope.profile = {
				id:1,
				email:'email@email.com',
				name:'FirstName LastName',
				position:'Frontend Dev',
				team:'HackIT',
				score:'8.8'
			};

		};
		console.log($scope.profile);
		//$scope.getProfile();
		$scope.progressBarClassColor = function(x){
			if(x>8){
				return 'progress-bar-green';
			}
			if(x>6){
				return 'progress-bar-light-blue';
			}
			if(x>4){
				return 'progress-bar-yellow';
			}
			return 'progress-bar-red';
		}
		$scope.labelScoreClass = function(x){
			var totalScores = 0;
			angular.forEach(x.skils, function(value, key) {
			  totalScores = totalScores + parseFloat(value.score);
			});
			totalScores = totalScores/x.skils.length;
			x.score = totalScores;

			if(x>8){
				return 'label-success';
			}
			if(x>6){
				return 'label-primary';
			}
			if(x>4){
				return 'label-warning';
			}
			return 'label-danger';
		}
	}]);
