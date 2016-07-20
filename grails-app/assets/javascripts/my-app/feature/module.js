//= require_self 
//= require controllers
//= require services 
//= require_tree /my-app/feature/templates/

'use strict';

angular.module('myApp.feature', [
	'grails', 
	'myApp.feature.controllers', 
	'myApp.feature.services'
])
.value('defaultCrudResource', 'FeatureResource')
.config(function($routeProvider) {
	$routeProvider
        .when('/', {
            controller: 'ListCtrl as ctrl',
            templateUrl: 'list.html',
            resolve: {
                featureList: function($route, FeatureResource) {
                    var params = $route.current.params;
                    return FeatureResource.list(params);
                } 
            }
        })
        .when('/create', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                feature: function(FeatureResource) {
                    return FeatureResource.create();
                } 
            }
        })
        .when('/edit/:id', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                feature: function($route, FeatureResource) {
                    var id = $route.current.params.id;
                    return FeatureResource.get(id);
                } 
            }
        })
        .when('/show/:id', {
            controller: 'ShowCtrl as ctrl',
            templateUrl: 'show.html',
            resolve: {
                feature: function($route, FeatureResource) {
                    var id = $route.current.params.id;
                    return FeatureResource.get(id);
                }
            }
        })
        .otherwise({redirectTo: '/'});
});
