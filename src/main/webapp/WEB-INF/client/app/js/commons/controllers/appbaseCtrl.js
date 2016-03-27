'use strict';
angular.module('hackathon-app')
    .controller('AppbaseCtrl', ['$scope', '$state', '$modal', '$http', 'LoginServices', function ($scope, $state, $modal, $http, LoginServices) {

        $scope.logout = function () {
            LoginServices.logout().then(function (response) {
                $state.go('login', true);
            });
        };

        $scope.myTeamSidebar = false;
        $scope.profilesSelected = [];

        $scope.addProfileToSelection = function (x) {
            var found = false;
            angular.forEach($scope.profilesSelected, function (value, key) {
                if (value.email == x.email) {
                    found = true;
                }
            });
            if (!found) {
                var y = angular.copy(x);
                y.selected = false;
                $scope.profilesSelected.push(y);
            }
        };

        $scope.selectProfileToTeam = function (x) {
            x.selected = true;
            $scope.transformProfileToMinMaxChart();
        };

        $scope.removeProfileFromTeam = function (x) {
            x.selected = false;
            $scope.transformProfileToMinMaxChart();
        };

        $scope.removeProfileFromSelection = function (x) {
            var y = $scope.profilesSelected.indexOf(x);
            if (y >= 0) {
                if (window.confirm('Are you sure about this?')) {
                    $scope.profilesSelected.splice(y, 1);
                }
            }
            $scope.transformProfileToMinMaxChart();
        };

        $scope.ifIsSaved = function (x) {
            var found = false;
            angular.forEach($scope.profilesSelected, function (value, key) {
                if (value.email == x.email) {
                    found = true;
                }
            });
            return !!found;
        };

        function determineMinValue(profiles, skill) {
            var min = 10;
            angular.forEach(profiles, function(profile){
                angular.forEach(profile.skillList, function(skillItem) {
                    if(skillItem.name == skill && skillItem.score < min) {
                        min = skillItem.score;
                    }
                })
            });
            return min;
        }

        function determineAvgValue(profiles, skill) {
            var sum = 0;
            var count = 0;
            angular.forEach(profiles, function(profile){
                angular.forEach(profile.skillList, function(skillItem) {
                    if(skillItem.name == skill) {
                        sum += skillItem.score;
                        count ++;
                    }
                })
            });

            if(count == 0) return 0;

            return sum/count;
        }

        function determineMaxValue(profiles, skill) {
            var max = 0;
            angular.forEach(profiles, function(profile){
                angular.forEach(profile.skillList, function(skillItem) {
                    if(skillItem.name == skill && skillItem.score > max) {
                        max = skillItem.score;
                    }
                })
            });
            return max;
        }

        $scope.transformProfileToMinMaxChart = function () {
            var categories = [];
            var data = [
            {
                name: 'Min',
                data: []
            },
            {
                name: 'Avrage',
                data: []
            },
            {
                name: 'Max',
                data: []
            }];
            angular.forEach($scope.profilesSelected, function (value, key) {
                angular.forEach(value.skillList, function (valuee) {
                    if (value.selected == true && !$scope.ifInCategory(categories, valuee.category)) {
                        categories.push(angular.copy(valuee.name));
                        data[0].data.push(determineMinValue($scope.profilesSelected, valuee.name));
                        data[1].data.push(determineAvgValue($scope.profilesSelected, valuee.name));
                        data[2].data.push(determineMaxValue($scope.profilesSelected, valuee.name));
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
                series: data
            });
        };

        $scope.ifInCategory = function (categories, x) {
            var found = false;
            angular.forEach(categories, function (value, key) {
                if (value == x) {
                    found = true;
                }
            });
            if (found) {
                return true;
            } else {
                return false;
            }
        };

        $scope.saveTeam = function() {
            var modalInstance = $modal.open({
                templateUrl: 'js/commons/views/team.html',
                controller: 'TeamController',
                backdrop: false,
                keyboard: false
            });

            modalInstance.result.then(function (result) {
              result.members = $scope.profilesSelected;
              $http.post('/apiproxy/api/team/save', result).then(function(result) {
                  console.log('Save successful');
              });
            })

        }

    }]);
