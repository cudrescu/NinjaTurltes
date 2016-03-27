'use strict';
angular.module('hackathon-app')
	.controller('ProfileCtrl', ['$scope','$state','ProfilesServices', function ($scope,$state,ProfilesServices) {

		$scope.getProfile = function() {

			ProfilesServices.getProfile($state.params.id).then(function(response){
				console.log(response);

				response = ProfilesServices.adaptSkilsToCategory(response);
				console.log(response);
				$scope.profile = response;
			});
			$scope.profile = {
				id:1,
				email:'email@email.com',
				name:'FirstName LastName',
				position:'Frontend Dev',
				team:'HackIT',
				score:'8.8'
			};

		};
		$scope.getProfile();
		$scope.progressBarClassColor = function(x){
			return makeColor(x);
		};
		$scope.labelScoreClass = function(x){
			var totalScores = 0;
			angular.forEach(x.skils, function(value, key) {
			  totalScores = totalScores + parseFloat(value.score);
			});
			totalScores = totalScores/x.skils.length;
			x.score = totalScores;

			return makeColor(totalScores);
		};
		function intToHex(i) {
        var hex = parseInt(i).toString(16);
        return (hex.length < 2) ? "0" + hex : hex;
    }
    function makeColor(value) {
        // value must be between [0, 510]
				value = parseFloat(value)/10;
        value = Math.min(Math.max(0,value), 1) * 510;
				//console.log(value);
        var redValue;
        var greenValue;
        if (value < 255) {
            redValue = 255;
            greenValue = Math.sqrt(value) * 16;
            greenValue = Math.round(greenValue);
        } else {
            greenValue = 255;
            value = value - 255;
            redValue = 255 - (value * value / 255);
            redValue = Math.round(redValue);
        }

        return "#" + intToHex(redValue) + intToHex(greenValue) + "99";
    }
	}]);
