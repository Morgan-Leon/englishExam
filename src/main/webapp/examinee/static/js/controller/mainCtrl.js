//mainCtrl.js
var ctrls = angular.module('nourControllers', ['nourConfig', 'ngResource'
        ,'singleChoiceServices']);

ctrls.controller("mainController",['$scope','SingleChoice'

  ,function($scope,SingleChoice){

    $scope.singleChoice = SingleChoice.get({id:1},function(date){
      console.log(date);
    })

}]);
