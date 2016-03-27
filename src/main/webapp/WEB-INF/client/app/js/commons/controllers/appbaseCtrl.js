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
			x.selected = true;
		};
		$scope.removeProfileFromTeam = function(x){
			x.selected = false;
		};
		$scope.removeProfileFromSelection = function(x){
			var y = $scope.profilesSelected.indexOf(x);
			if(y>=0){
				if(window.confirm('Are you sure about this?')){
						$scope.profilesSelected.splice(y,1);
				}
			}
		};
		$scope.ifIsSaved = function(x){
			var found = false;
      angular.forEach($scope.profilesSelected, function(value, key) {
        if(value.email==x.email){
          found = true;
        }
      });
			if(found){
				return true;
			}else{
				return false;
			}
		};
		$scope.data = {
        dataset0: [
          {x: 0, val_0: 0, val_1: 0, val_2: 0, val_3: 0},
          {x: 1, val_0: 0.993, val_1: 3.894, val_2: 8.47, val_3: 14.347},
          {x: 2, val_0: 1.947, val_1: 7.174, val_2: 13.981, val_3: 19.991},
          {x: 3, val_0: 2.823, val_1: 9.32, val_2: 14.608, val_3: 13.509},
          {x: 4, val_0: 3.587, val_1: 9.996, val_2: 10.132, val_3: -1.167},
          {x: 5, val_0: 4.207, val_1: 9.093, val_2: 2.117, val_3: -15.136},
          {x: 6, val_0: 4.66, val_1: 6.755, val_2: -6.638, val_3: -19.923},
          {x: 7, val_0: 4.927, val_1: 3.35, val_2: -13.074, val_3: -12.625}
        ]
      };
		$scope.options = {
		  margin: {top: 5},
		  series: [
		    {
		      axis: "y",
		      dataset: "tolerance",
		      key: "average",
		      label: "Main series",
		      color: "hsla(88, 48%, 48%, 1)",
		      type: ["dot", "line"],
		      id: "tolerance"
		    },
		    {
		      axis: "y",
		      dataset: "tolerance",
		      key: {y0: "extrema_min", y1: "extrema_max"},
		      label: "Extrema",
		      color: "hsla(88, 48%, 48%, 1)",
		      type: ["area"],
		      id: "extrema"
		    }
		  ],
		  axes: {
		    x: {key: "x"},
		    y: {min: 0, max: 40}
		  }
		};


	}]);
