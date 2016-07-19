'use strict';

function ListCtrl($scope, EmployeeResource, employeeList, pageSize) {
    var self = this;
    self.employeeList = employeeList;
	
    self.pageSize = pageSize;
    self.page = 1;
    self.filter = {};

    $scope.$watchCollection(function() { return self.filter }, function() {
        self.reload();
    });

    self.load = function() {
        var params = {page: self.page};

        if (self.sort) {
            angular.extend(params, self.sort);
        }
		if (self.filter) {
			params.filter = self.filter
		}

        EmployeeResource.list(params).then(function(items) {
            self.employeeList = items;
        });
    };

    self.reload = function() {
        self.page = 1;
        self.load();
    }
}

function ShowCtrl(employee) {
    var self = this;
    self.employee = employee;
};

function CreateEditCtrl(employee ) {
    var self = this;
	
    self.employee = employee;
}

angular.module('myApp.employee.controllers', [])
    .controller('ListCtrl', ListCtrl)
    .controller('ShowCtrl', ShowCtrl)
    .controller('CreateEditCtrl', CreateEditCtrl);