(function () {
    'use strict';

    angular.module('hackathon-app', ['ui.router','ui.bootstrap','ng-fusioncharts'])

        .config(function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise('/login');
            $stateProvider
                .state('appbase',{
                    abstract:true,
                    controller:'AppbaseCtrl',
                    templateUrl:'js/commons/views/base.html'
                }).state('dashboard', {
                    url:'/dashboard',
                    parent:'appbase',
                    templateUrl: 'js/dashboard/views/dashboard.html',
                    controller: 'DashboardCtrl'
                }).state('users', {
                    url:'/users',
                    parent:'appbase',
                    templateUrl: 'js/users/views/users.html',
                    controller: 'UsersCtrl'
                }).state('profiles', {
                    url:'/profiles',
                    parent:'appbase',
                    templateUrl: 'js/profiles/views/profiles.html',
                    controller: 'ProfilesCtrl'
                }).state('profile', {
                    url:'/profile/:id',
                    parent:'appbase',
                    templateUrl: 'js/profiles/views/profile.html',
                    controller: 'ProfileCtrl'
                }).state('teams', {
                    url:'/teams',
                    parent:'appbase',
                    templateUrl: 'js/teams/views/teams.html',
                    controller: 'TeamsCtrl'
                }).state('search', {
                    url:'/search',
                    parent:'appbase',
                    templateUrl: 'js/search/views/search.html',
                    controller: 'SearchCtrl',
                    resolve: {
                        skillCategories: function($q, SearchService) {
                            var skillCategoriesPromise = $q.defer();
                            SearchService.getAllSkillCategories().then(
                                function(result) {
                                    skillCategoriesPromise.resolve(result.data);
                                }
                            );
                            return skillCategoriesPromise.promise;
                        },
                        skills: function($q, SearchService) {
                            var skillsPromise = $q.defer();
                            SearchService.getAllSkills().then(
                                function(result) {
                                    skillsPromise.resolve(result.data);
                                }
                            );
                            return skillsPromise.promise;
                        },
                        positions: function($q, SearchService) {
                            var positionsPromise = $q.defer();
                            SearchService.getAllPositions().then(
                                function(result) {
                                    positionsPromise.resolve(result.data);
                                }
                            );
                            return positionsPromise.promise;
                        }
                    }
                }).state('login', {
                    url:'/login',
                    templateUrl: 'js/auth/views/login.html',
                    controller: 'LoginCtrl'
                });
        })
        .run(function($rootScope, $httpBackend) {
            $rootScope.$on('$stateChangeSuccess',
                function(event, toState, toParams, fromState, fromParams){
                    $rootScope.currentState = toState.name;
                    setTimeout(function(){
                        $(window).resize();
                    },100);
                }
            );

        });

})();
