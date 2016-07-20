//= require_self 
//= require controllers
//= require services 
//= require_tree /my-app/tag/templates/

'use strict';

angular.module('myApp.tag', [
	'grails', 
	'myApp.tag.controllers', 
	'myApp.tag.services'
])
.value('defaultCrudResource', 'TagResource')
.config(function($routeProvider) {
	$routeProvider
        .when('/', {
            controller: 'ListCtrl as ctrl',
            templateUrl: 'list.html',
            resolve: {
                tagList: function($route, TagResource) {
                    var params = $route.current.params;
                    return TagResource.list(params);
                } 
            }
        })
        .when('/create', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                tag: function(TagResource) {
                    return TagResource.create();
                } 
            }
        })
        .when('/edit/:id', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                tag: function($route, TagResource) {
                    var id = $route.current.params.id;
                    return TagResource.get(id);
                } 
            }
        })
        .when('/show/:id', {
            controller: 'ShowCtrl as ctrl',
            templateUrl: 'show.html',
            resolve: {
                tag: function($route, TagResource) {
                    var id = $route.current.params.id;
                    return TagResource.get(id);
                }
            }
        })
        .otherwise({redirectTo: '/'});
});
