'use strict';

function TagResource(CrudResourceFactory) {
    return CrudResourceFactory('/api/tag', 'Tag');
}

angular.module('myApp.tag.services', ['grails'])
    .factory('TagResource', TagResource);
