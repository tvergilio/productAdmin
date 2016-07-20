//= require_self 
//= require controllers
//= require services 
//= require /my-app/image/services

//= require /my-app/category/services
//= require_tree /my-app/category/templates/

'use strict';

angular.module('myApp.category', [
	'grails', 
	'myApp.category.controllers', 
	'myApp.image.services',
	'myApp.category.services',
	'myApp.category.services'
])
.value('defaultCrudResource', 'CategoryResource')
.config(function($routeProvider) {
	$routeProvider
        .when('/', {
            controller: 'ListCtrl as ctrl',
            templateUrl: 'list.html',
            resolve: {
                categoryList: function($route, CategoryResource) {
                    var params = $route.current.params;
                    return CategoryResource.list(params);
                },
				imageList: function(ImageResource) {
					return ImageResource.list();
				}	
, 
				categoryList: function(CategoryResource) {
					return CategoryResource.list();
				}	
 
            }
        })
        .when('/create', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                category: function(CategoryResource) {
                    return CategoryResource.create();
                },
				imageList: function(ImageResource) {
					return ImageResource.list();
				}	
, 
				categoryList: function(CategoryResource) {
					return CategoryResource.list();
				}	
 
            }
        })
        .when('/edit/:id', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                category: function($route, CategoryResource) {
                    var id = $route.current.params.id;
                    return CategoryResource.get(id);
                },
				imageList: function(ImageResource) {
					return ImageResource.list();
				}	
, 
				categoryList: function(CategoryResource) {
					return CategoryResource.list();
				}	
 
            }
        })
        .when('/show/:id', {
            controller: 'ShowCtrl as ctrl',
            templateUrl: 'show.html',
            resolve: {
                category: function($route, CategoryResource) {
                    var id = $route.current.params.id;
                    return CategoryResource.get(id);
                }
            }
        })
        .otherwise({redirectTo: '/'});
});
