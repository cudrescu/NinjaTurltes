angular.module("hackathon-app").factory('ProfilesServices',['$http', function($http) {
	return {
		getList: function(data){
			return $http.post('apiproxy/api/profile/search',data).then(function(response) {
				return response.data;
			});
		},
		getProfile: function(data){
			return $http.get('apiproxy/api/profile?email='+data).then(function(response) {
				return response.data;
			});
		},
    adaptSkilsToCategory:function(data){
      var categories = [];
      console.log(data);
      var e = this;
      angular.forEach(data.skillList, function(value, key) {
        var category = e.categoryExist(categories,value.category);
        if(category==-1){
          console.log(angular.copy(value));
          categories.push({name:angular.copy(value.category),skils:[angular.copy(value)]});
        }else{
          categories[angular.copy(category)].skils.push(angular.copy(value));
        }
      });
      data.technologies = categories;
      return data;
    },
    categoryExist:function(categories,x){
      var found = -1;
      angular.forEach(categories, function(value, key) {
        if(value.name==x){
          found = key;
        }
      });
      return found;
    }

	}
}])
