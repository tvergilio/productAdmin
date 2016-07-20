'use strict';

function ListCtrl($scope, ShippingResource, shippingList, pageSize) {
    var self = this;
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

        ShippingResource.list(params).then(function(items) {
            self.shippingList = items;
        });
    };

    self.reload = function() {
        self.page = 1;
        self.load();
    }
}

function ShowCtrl(shipping) {
    var self = this;
    self.shipping = shipping;
};

function CreateEditCtrl(shipping ) {
    var self = this;
	
    self.shipping = shipping;
}

angular.module('myApp.shipping.controllers', [])
    .controller('ListCtrl', ListCtrl)
    .controller('ShowCtrl', ShowCtrl)
    .controller('CreateEditCtrl', CreateEditCtrl);