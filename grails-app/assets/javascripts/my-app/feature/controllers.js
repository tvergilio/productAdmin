'use strict';

function ListCtrl($scope, FeatureResource, featureList, pageSize) {
    var self = this;
    self.featureList = featureList;
	
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

        FeatureResource.list(params).then(function(items) {
            self.featureList = items;
        });
    };

    self.reload = function() {
        self.page = 1;
        self.load();
    }
}

function ShowCtrl(feature) {
    var self = this;
    self.feature = feature;
};

function CreateEditCtrl(feature ) {
    var self = this;
	
    self.feature = feature;
}

angular.module('myApp.feature.controllers', [])
    .controller('ListCtrl', ListCtrl)
    .controller('ShowCtrl', ShowCtrl)
    .controller('CreateEditCtrl', CreateEditCtrl);