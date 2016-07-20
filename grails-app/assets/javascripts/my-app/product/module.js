//= require_self 
//= require controllers
//= require services 
//= require /my-app/shipping/services
//= require_tree /my-app/product/templates/

'use strict';

angular.module('myApp.product', [
	'grails', 
	'myApp.product.controllers', 
	'myApp.shipping.services',
	'myApp.product.services'
])
.value('defaultCrudResource', 'ProductResource')
.config(function($routeProvider) {
	$routeProvider
        .when('/', {
            controller: 'ListCtrl as ctrl',
            templateUrl: 'list.html',
            resolve: {
                productList: function($route, ProductResource) {
                    var params = $route.current.params;
                    return ProductResource.list(params);
                },
				shippingList: function(ShippingResource) {
					return ShippingResource.list();
				}	
 
            }
        })
        .when('/create', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                product: function(ProductResource) {
                    return ProductResource.create();
                },
				shippingList: function(ShippingResource) {
					return ShippingResource.list();
				}	
 
            }
        })
        .when('/edit/:id', {
            controller: 'CreateEditCtrl as ctrl',
            templateUrl: 'create-edit.html',
            resolve: {
                product: function($route, ProductResource) {
                    var id = $route.current.params.id;
                    return ProductResource.get(id);
                },
				shippingList: function(ShippingResource) {
					return ShippingResource.list();
				}	
 
            }
        })
        .when('/show/:id', {
            controller: 'ShowCtrl as ctrl',
            templateUrl: 'show.html',
            resolve: {
                product: function($route, ProductResource) {
                    var id = $route.current.params.id;
                    return ProductResource.get(id);
                }
            }
        })
        .otherwise({redirectTo: '/'});
});
