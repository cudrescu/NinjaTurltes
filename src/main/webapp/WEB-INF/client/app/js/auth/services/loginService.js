angular.module("hackathon-app").factory('LoginServices',['$http', function($http) {
	return {
		login: function(data){
			return $http.post('apiproxy/auth/login',data).then(function(response) {
				return response.data;
			});
		},
		logout: function(){
			return $http.delete('apiproxy/auth/logout').then(function(response) {
				return response.data;
			});
		}
	}
}]);