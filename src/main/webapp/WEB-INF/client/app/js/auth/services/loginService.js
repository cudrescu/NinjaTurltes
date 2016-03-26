angular.module("hackathon-app").factory('LoginServices',['$http', function($http) {
	return {
		login: function(data){
			return $http.post('apiproxi/auth/login',data).then(function(response) {
				return response.data;
			});
		}

	}
}])