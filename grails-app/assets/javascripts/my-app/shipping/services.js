'use strict';

function ShippingResource(CrudResourceFactory) {
    return CrudResourceFactory('/api/shipping', 'Shipping');
}

angular.module('myApp.shipping.services', ['grails'])
    .factory('ShippingResource', ShippingResource);
