'use strict';

function EmployeeResource(CrudResourceFactory) {
    return CrudResourceFactory('/api/employee', 'Employee');
}

angular.module('myApp.employee.services', ['grails'])
    .factory('EmployeeResource', EmployeeResource);
