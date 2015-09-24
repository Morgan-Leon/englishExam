var singleChoiceServices = angular.module('singleChoiceServices', ['ngResource', "nourConfig"]);

// singleChoice object(s)
singleChoiceServices.factory('SingleChoice',['$resource', 'config',
	function($resource, config){
		return $resource(config.HOST + "singleChoice/:id",
            {id:'@id'}, {}
        );
	}]);
