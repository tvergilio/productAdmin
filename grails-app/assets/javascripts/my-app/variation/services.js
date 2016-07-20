'use strict';

function VariationResource(CrudResourceFactory) {
    return CrudResourceFactory('/api/variation', 'Variation');
}

angular.module('myApp.variation.services', ['grails'])
    .factory('VariationResource', VariationResource);
