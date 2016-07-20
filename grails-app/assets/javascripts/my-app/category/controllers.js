'use strict';

function ListCtrl($scope, CategoryResource, categoryList, imageList, parentList, pageSize) {
    var self = this;
    self.categoryList = categoryList;
	self.imageList = imageList;
self.parentList = parentList;
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

        CategoryResource.list(params).then(function(items) {
            self.categoryList = items;
        });
    };

    self.reload = function() {
        self.page = 1;
        self.load();
    }
}

function ShowCtrl(category) {
    var self = this;
    self.category = category;
};

function CreateEditCtrl(category, imageList, parentList ) {
    var self = this;
	self.imageList = imageList;
self.parentList = parentList;
    self.category = category;
}

angular.module('myApp.category.controllers', [])
    .controller('ListCtrl', ListCtrl)
    .controller('ShowCtrl', ShowCtrl)
    .controller('CreateEditCtrl', CreateEditCtrl);