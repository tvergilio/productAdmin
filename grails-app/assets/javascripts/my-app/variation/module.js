//= require_self 
//= require controllers
//= require services 
//= require /my-app/image/services

//= require /my-app/shipping/services
//= require_tree /my-app/variation/templates/

'use strict';

angular.module('myApp.variation', [
	'grails', 
	'myApp.variation.controllers', 
	'myApp.image.services',
	'myApp.shipping.services',
	'myApp.variation.services'
])
.value('defaultCrudResource', 'VariationResource')
.config(function($routeProvider) {
	$routeProvider
        .when('/', {
            controller: 'ListCtrl as ctrl',
            templateUrl: 'list.html',
            resolve: {
                variationList: function($route, VariationResource) {
                    var params = $route.current.params;
                    return VariationResource.list(params);
                },
				imageList: function(ImageResource) {
					return ImageResource.list();
				}	
, 
				shippingList: function(ShippingResource) {
					return ShippingResource.list();
				}	
 
            }
        })
        .when('/create', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                variation: function(VariationResource) {
                    return VariationResource.create();
                },
				imageList: function(ImageResource) {
					return ImageResource.list();
				}	
, 
				shippingList: function(ShippingResource) {
					return ShippingResource.list();
				}	
 
            }
        })
        .when('/edit/:id', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                variation: function($route, VariationResource) {
                    var id = $route.current.params.id;
                    return VariationResource.get(id);
                },
				imageList: function(ImageResource) {
					return ImageResource.list();
				}	
, 
				shippingList: function(ShippingResource) {
					return ShippingResource.list();
				}	
 
            }
        })
        .when('/show/:id', {
            controller: 'ShowCtrl as ctrl',
            templateUrl: 'show.html',
            resolve: {
                variation: function($route, VariationResource) {
                    var id = $route.current.params.id;
                    return VariationResource.get(id);
                }
            }
        })
        .otherwise({redirectTo: '/'});
});
