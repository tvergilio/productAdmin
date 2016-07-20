'use strict';

function FeatureResource(CrudResourceFactory) {
    return CrudResourceFactory('/api/feature', 'Feature');
}

angular.module('myApp.feature.services', ['grails'])
    .factory('FeatureResource', FeatureResource);
