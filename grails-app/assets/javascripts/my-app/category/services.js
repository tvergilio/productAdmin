'use strict';

function CategoryResource(CrudResourceFactory) {
    return CrudResourceFactory('/api/category', 'Category');
}

angular.module('myApp.category.services', ['grails'])
    .factory('CategoryResource', CategoryResource);
