(function () {
    'use strict';

    angular.module('hackathon-app', ['ui.router'])

        .config(function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise('/login');
            $stateProvider
                .state('appbase',{
                    abstract:true,
                    controller:'AppbaseCtrl',
                    templateUrl:'js/commons/views/base.html'
                })
                .state('dashboard', {
                    url:'/dashboard',
                    parent:'appbase',
                    templateUrl: 'js/dashboard/views/dashboard.html',
                    controller: 'DashboardCtrl'
                })
                .state('users', {
                    url:'/users',
                    parent:'appbase',
                    templateUrl: 'js/users/views/users.html',
                    controller: 'UsersCtrl'
                })
                .state('profiles', {
                    url:'/profiles',
                    parent:'appbase',
                    templateUrl: 'js/profiles/views/profiles.html',
                    controller: 'ProfilesCtrl'
                }).state('teams', {
                    url:'/teams',
                    parent:'appbase',
                    templateUrl: 'js/teams/views/teams.html',
                    controller: 'TeamsCtrl'
                }).state('search', {
                    url:'/search',
                    parent:'appbase',
                    templateUrl: 'js/search/views/search.html',
                    controller: 'SearchCtrl'
                }).state('login', {
                    url:'/login',
                    templateUrl: 'js/auth/views/login.html',
                    controller: 'LoginCtrl'
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

        });

})();