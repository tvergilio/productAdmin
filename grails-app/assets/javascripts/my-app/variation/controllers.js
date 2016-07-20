'use strict';

function ListCtrl($scope, VariationResource, variationList, imageList, shippingList, pageSize) {
    var self = this;
    self.variationList = variationList;
	self.imageList = imageList;
self.shippingList = shippingList;
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

        VariationResource.list(params).then(function(items) {
            self.variationList = items;
        });
    };

    self.reload = function() {
        self.page = 1;
        self.load();
    }
}

function ShowCtrl(variation) {
    var self = this;
    self.variation = variation;
};

function CreateEditCtrl(variation, imageList, shippingList ) {
    var self = this;
	self.imageList = imageList;
self.shippingList = shippingList;
    self.variation = variation;
}

angular.module('myApp.variation.controllers', [])
    .controller('ListCtrl', ListCtrl)
    .controller('ShowCtrl', ShowCtrl)
    .controller('CreateEditCtrl', CreateEditCtrl);