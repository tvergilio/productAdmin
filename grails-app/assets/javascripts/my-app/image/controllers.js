'use strict';

function ListCtrl($scope, ImageResource, imageList, pageSize) {
    var self = this;
    self.imageList = imageList;
	
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

        ImageResource.list(params).then(function(items) {
            self.imageList = items;
        });
    };

    self.reload = function() {
        self.page = 1;
        self.load();
    }
}

function ShowCtrl(image) {
    var self = this;
    self.image = image;
};

function CreateEditCtrl(image ) {
    var self = this;
	
    self.image = image;
}

angular.module('myApp.image.controllers', [])
    .controller('ListCtrl', ListCtrl)
    .controller('ShowCtrl', ShowCtrl)
    .controller('CreateEditCtrl', CreateEditCtrl);