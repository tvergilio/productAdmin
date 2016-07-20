'use strict';

function ImageResource(CrudResourceFactory) {
    return CrudResourceFactory('/api/image', 'Image');
}

angular.module('myApp.image.services', ['grails'])
    .factory('ImageResource', ImageResource);
