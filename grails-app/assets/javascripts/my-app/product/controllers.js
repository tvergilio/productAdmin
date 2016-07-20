'use strict';

function ListCtrl($scope, ProductResource, productList, shippingList, pageSize) {
    var self = this;
    self.productList = productList;
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

        ProductResource.list(params).then(function(items) {
            self.productList = items;
        });
    };

    self.reload = function() {
        self.page = 1;
        self.load();
    }
}

function ShowCtrl(product) {
    var self = this;
    self.product = product;
};

function CreateEditCtrl(product, shippingList ) {
    var self = this;
	self.shippingList = shippingList;
    self.product = product;
}

angular.module('myApp.product.controllers', [])
    .controller('ListCtrl', ListCtrl)
    .controller('ShowCtrl', ShowCtrl)
    .controller('CreateEditCtrl', CreateEditCtrl);