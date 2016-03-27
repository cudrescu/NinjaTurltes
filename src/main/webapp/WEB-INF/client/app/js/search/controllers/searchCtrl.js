'use strict';
angular.module('hackathon-app')
	.controller('SearchCtrl', ['$scope', 'skillCategories', 'skills', 'positions', 'SearchService', function ($scope, skillCategories, skills, positions, SearchService) {

		$scope.technologies = formatSkills(skills, skillCategories);
		$scope.positions = positions;
		$scope.accordionStatus = initAccordions(skillCategories.length, true);
		$scope.profiles = [];
		$scope.showResultsPanel = false;

		function formatSkills(skills, skillCategories) {
			var formattedSkills = [];
			angular.forEach(skillCategories, function(category) {
				var categSkills = [];
				angular.forEach(skills, function(skill) {
					if(category == skill.skillCategory) {
						categSkills.push(skill);
					}
				});
				formattedSkills.push({category: category, skillList: categSkills});
			});

			return formattedSkills;
		}

		function initAccordions(count, value) {
			var accordionStatus = [];
			for(var i = 0; i<count; i++) {
				accordionStatus[i] = value;
			}
			return accordionStatus;
		}

		function buildRequestData(filter) {

			var requestData = {
				position: filter.position,
				skills: []
			};

			angular.forEach(skills, function(skill) {
				if(filter.hasOwnProperty(skill.name)) {
					if(filter[skill.name].selected) {
						requestData.skills.push({
							name: skill.name,
							score: filter[skill.name].score != null ? filter[skill.name].score : 0
						})
					}
				}
			});

			return requestData;
		}

		$scope.collapse = function(index) {
			$scope.accordionStatus[index] = !$scope.accordionStatus[index];
		};

		$scope.isAccordionActive = function(index) {
			return $scope.accordionStatus[index];
		};

		$scope.getRecommendedMembers = function() {
			var requestData = buildRequestData($scope.filter);
			SearchService.recommendMembers(requestData).then(
				function(result) {
					$scope.accordionStatus = initAccordions(skillCategories.length, false);
					$scope.showResultsPanel = true;
					$scope.profiles = result.data;
				}
			)
		}



	}]);