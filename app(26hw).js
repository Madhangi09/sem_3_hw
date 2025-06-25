var app = angular.module('studentPortalApp', ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "home.html"
        })
        .when("/about", {
            templateUrl: "about.html"
        })
        .when("/students", {
            templateUrl: "students.html",
            controller: "StudentsController"
        })
        .otherwise({
            redirectTo: "/"
        });
});

app.controller('StudentsController', function($scope) {
    $scope.students = ["Alice", "Bob", "Charlie", "David"];
});
