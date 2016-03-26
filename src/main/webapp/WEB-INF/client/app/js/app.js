(function () {
    'use strict';

    angular.module('hackathon-app', ['ui.router'])

        .config(function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise('/dashboard');
            $stateProvider
                .state('dashboard', {
                    url:'/dashboard',
                    templateUrl: 'js/dashboard/views/dashboard.html',
                    controller: 'DashboardCtrl'
                })
                .state('users', {
                    url:'/users',
                    templateUrl: 'js/users/views/users.html',
                    controller: 'UsersCtrl'
                })
                .state('profiles', {
                    url:'/profiles',
                    templateUrl: 'js/profiles/views/profiles.html',
                    controller: 'ProfilesCtrl'
                }).state('teams', {
                    url:'/teams',
                    templateUrl: 'js/teams/views/teams.html',
                    controller: 'TeamsCtrl'
                }).state('search', {
                    url:'/search',
                    templateUrl: 'js/search/views/search.html',
                    controller: 'SearchCtrl'
                });
        })
        .run(function($rootScope, $httpBackend) {
            //$rootScope.user = window.user;
            $rootScope.$on('$stateChangeSuccess',
                function(event, toState, toParams, fromState, fromParams){
                    //console.log(toState.name);
                    $rootScope.currentState = toState.name;
                }
            );

        })

})();