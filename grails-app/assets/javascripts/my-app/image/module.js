//= require_self 
//= require controllers
//= require services 
//= require_tree /my-app/image/templates/

'use strict';

angular.module('myApp.image', [
	'grails', 
	'myApp.image.controllers', 
	'myApp.image.services'
])
.value('defaultCrudResource', 'ImageResource')
.config(function($routeProvider) {
	$routeProvider
        .when('/', {
            controller: 'ListCtrl as ctrl',
            templateUrl: 'list.html',
            resolve: {
                imageList: function($route, ImageResource) {
                    var params = $route.current.params;
                    return ImageResource.list(params);
                } 
            }
        })
        .when('/create', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                image: function(ImageResource) {
                    return ImageResource.create();
                } 
            }
        })
        .when('/edit/:id', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                image: function($route, ImageResource) {
                    var id = $route.current.params.id;
                    return ImageResource.get(id);
                } 
            }
        })
        .when('/show/:id', {
            controller: 'ShowCtrl as ctrl',
            templateUrl: 'show.html',
            resolve: {
                image: function($route, ImageResource) {
                    var id = $route.current.params.id;
                    return ImageResource.get(id);
                }
            }
        })
        .otherwise({redirectTo: '/'});
});
