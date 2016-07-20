//= require_self 
//= require controllers
//= require services 
//= require_tree /my-app/shipping/templates/

'use strict';

angular.module('myApp.shipping', [
	'grails', 
	'myApp.shipping.controllers', 
	'myApp.shipping.services'
])
.value('defaultCrudResource', 'ShippingResource')
.config(function($routeProvider) {
	$routeProvider
        .when('/', {
            controller: 'ListCtrl as ctrl',
            templateUrl: 'list.html',
            resolve: {
                shippingList: function($route, ShippingResource) {
                    var params = $route.current.params;
                    return ShippingResource.list(params);
                } 
            }
        })
        .when('/create', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                shipping: function(ShippingResource) {
                    return ShippingResource.create();
                } 
            }
        })
        .when('/edit/:id', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                shipping: function($route, ShippingResource) {
                    var id = $route.current.params.id;
                    return ShippingResource.get(id);
                } 
            }
        })
        .when('/show/:id', {
            controller: 'ShowCtrl as ctrl',
            templateUrl: 'show.html',
            resolve: {
                shipping: function($route, ShippingResource) {
                    var id = $route.current.params.id;
                    return ShippingResource.get(id);
                }
            }
        })
        .otherwise({redirectTo: '/'});
});
