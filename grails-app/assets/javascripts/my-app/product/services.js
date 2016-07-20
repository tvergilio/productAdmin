'use strict';

function ProductResource(CrudResourceFactory) {
    return CrudResourceFactory('/api/product', 'Product');
}

angular.module('myApp.product.services', ['grails'])
    .factory('ProductResource', ProductResource);
