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
			$scope.transformProfileToMinMaxChart();
		};
		$scope.removeProfileFromTeam = function(x){
			x.selected = false;
			$scope.transformProfileToMinMaxChart();
		};
		$scope.removeProfileFromSelection = function(x){
			var y = $scope.profilesSelected.indexOf(x);
			if(y>=0){
				if(window.confirm('Are you sure about this?')){
						$scope.profilesSelected.splice(y,1);
				}
			}
			$scope.transformProfileToMinMaxChart();
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
		$scope.transformProfileToMinMaxChart = function(){
			var categories = [];
			var data = [{
					name: 'Min',
					data: []
			}, {
					name: 'Avrage',
					data: []
			}, {
					name: 'Max',
					data: []
			}];
			angular.forEach($scope.profilesSelected, function(value, key) {
				angular.forEach(value.skillList, function(valuee) {
	        if(value.selected==true && !$scope.ifInCategory(categories,valuee.category)){
						categories.push(angular.copy(valuee.name));
						data[0].data.push(0);
						data[1].data.push(0);
						data[2].data.push(0);
	        }
				});
      });
			angular.forEach(categories, function(valuee,keyy) {
				angular.forEach($scope.profilesSelected, function(value, key) {
					if(value.selected==true && !$scope.ifInCategory(categories,valuee.category)){
						if(data[0].data[keyy]!=0 && data[0].data[keyy]>value.score){
								data[0].data[keyy] = value.score;
						}

						//data[1].data[keyy] = value.score;
						data[2].data[keyy] = value.score;
					}
				});
			});

			$('.chartTeamHere').highcharts({
        chart: {
            type: 'column'
        },
        title: false,
        xAxis: {
            categories: angular.copy(categories)
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Skills in points'
            },
            stackLabels: {
                enabled: true,
                style: {
                    fontWeight: 'bold',
                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                }
            }
        },
        legend: {
            align: 'right',
            x: -30,
            verticalAlign: 'top',
            y: 25,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
            borderColor: '#CCC',
            borderWidth: 1,
            shadow: false
        },
        tooltip: {
            headerFormat: '<b>{point.x}</b><br/>',
            pointFormat: '{series.name}: {point.y}'
        },
        plotOptions: {
            column: {
                stacking: 'normal',
                dataLabels: {
                    enabled: true,
                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                    style: {
                        textShadow: '0 0 3px black'
                    }
                }
            }
        },
        series: [{
            name: 'Min',
            data: [5, 3, 4, 7, 2]
        }, {
            name: 'Avrage',
            data: [2, 2, 3, 2, 1]
        }, {
            name: 'Max',
            data: [3, 4, 4, 2, 5]
        }]
    });
		};
		$scope.ifInCategory = function(categories,x){
			var found = false;
      angular.forEach(categories, function(value, key) {
        if(value==x){
          found = true;
        }
      });
			if(found){
				return true;
			}else{
				return false;
			}
		}

		$scope.data = {
    "chart": {
        "showvalues": "0",
        "plotgradientcolor": "",
        "formatnumberscale": "0",
        "showplotborder": "0",
        "palettecolors": "#EED17F,#97CBE7,#074868,#B0D67A,#2C560A,#DD9D82",
        "canvaspadding": "0",
        "bgcolor": "FFFFFF",
        "showalternatehgridcolor": "0",
        "divlinecolor": "CCCCCC",
        "showcanvasborder": "0",
        "legendborderalpha": "0",
        "legendshadow": "0",
        "interactivelegend": "0",
        "showpercentvalues": "1",
        "showsum": "1",
        "canvasborderalpha": "0",
        "showborder": "0"
    },
    "categories": [
        {
            "category": [
                {
                    "label": "Jan"
                },
                {
                    "label": "Feb"
                },
                {
                    "label": "Mar"
                },
                {
                    "label": "Apr"
                },
                {
                    "label": "May"
                },
                {
                    "label": "Jun"
                },
                {
                    "label": "Jul"
                },
                {
                    "label": "Aug"
                },
                {
                    "label": "Sep"
                },
                {
                    "label": "Oct"
                },
                {
                    "label": "Nov"
                },
                {
                    "label": "Dec"
                }
            ]
        }
    ],
    "dataset": [
        {
            "seriesname": "Min",
            "renderas": "Area",
            "data": [
                {
                    "value": "5040"
                },
                {
                    "value": "4794"
                },
                {
                    "value": "5026"
                }
            ]
        },
        {
            "seriesname": "Avvrage",
            "renderas": "Area",
            "data": [
                {
                    "value": "1200"
                },
                {
                    "value": "1124"
                },
                {
                    "value": "1006"
                }
            ]
        },
        {
            "seriesname": "Max",
            "renderas": "Area",
            "data": [
                {
                    "value": "400"
                },
                {
                    "value": "524"
                },
                {
                    "value": "606"
                }
            ]
        }
    ]
}


	}]);
