(function() {
    angular.module("hackathon-app")
        .factory('SearchService',['$http', function($http) {

            var getAllCategoriesUrl = '/apiproxy/api/skillcategory/all';
            var getAllSkillsUrl = '/apiproxy/api/skill/all';
            var getAllPositionsUrl = '/apiproxy/api/userposition/all';
            var recommendMembersUrl = '/apiproxy/api/recommend';

            return {
                getAllSkillCategories: getAllSkillCategories,
                getAllSkills: getAllSkills,
                getAllPositions: getAllPositions,
                recommendMembers: recommendMembers
            };

            function getAllSkillCategories() {
                return $http.get(getAllCategoriesUrl);
            }

            function getAllSkills() {
                return $http.get(getAllSkillsUrl);
            }

            function getAllPositions() {
                return $http.get(getAllPositionsUrl);
            }

            function recommendMembers(requestData) {
                return $http.post(recommendMembersUrl, requestData);
            }

        }]);
})();