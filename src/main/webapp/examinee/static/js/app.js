// app.js

//Main Angular script file for application

//create a module with injected modules in brackets
var routeApp = angular.module('route',['ngResource', 'ui.router', 'nourControllers', 'nourConfig']);

// router config
routeApp.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider, $routeProvider, $httpProvider) {

  $urlRouterProvider
  // .when('/teachingCenter', '/teachingCenter/myTask')
  // .when('/teachingCenter/addBook', '/teachingCenter/addBook/quick')
  // .when('/statistics', '/statistics/students')
  // .when('/statistics/classes', '/statistics/classes/coins')
  .otherwise('/');

  // $httpProvider.responseInterceptors.push('SecurityHttpInterceptor');

  $stateProvider
      //main page
      .state('main', {
          url: '/',
          templateUrl: "partials/main.html",
          controller: "mainController"
      })

}]);
