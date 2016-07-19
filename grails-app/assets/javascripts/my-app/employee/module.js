//= require_self 
//= require controllers
//= require services 
//= require_tree /my-app/employee/templates/

'use strict';

angular.module('myApp.employee', [
	'grails', 
	'myApp.employee.controllers', 
	'myApp.employee.services'
])
.value('defaultCrudResource', 'EmployeeResource')
.config(function($routeProvider) {
	$routeProvider
        .when('/', {
            controller: 'ListCtrl as ctrl',
            templateUrl: 'list.html',
            resolve: {
                employeeList: function($route, EmployeeResource) {
                    var params = $route.current.params;
                    return EmployeeResource.list(params);
                } 
            }
        })
        .when('/create', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                employee: function(EmployeeResource) {
                    return EmployeeResource.create();
                } 
            }
        })
        .when('/edit/:id', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                employee: function($route, EmployeeResource) {
                    var id = $route.current.params.id;
                    return EmployeeResource.get(id);
                } 
            }
        })
        .when('/show/:id', {
            controller: 'ShowCtrl as ctrl',
            templateUrl: 'show.html',
            resolve: {
                employee: function($route, EmployeeResource) {
                    var id = $route.current.params.id;
                    return EmployeeResource.get(id);
                }
            }
        })
        .otherwise({redirectTo: '/'});
});
