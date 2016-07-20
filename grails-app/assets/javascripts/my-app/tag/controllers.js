'use strict';

function ListCtrl($scope, TagResource, tagList, pageSize) {
    var self = this;
    self.tagList = tagList;
	
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

        TagResource.list(params).then(function(items) {
            self.tagList = items;
        });
    };

    self.reload = function() {
        self.page = 1;
        self.load();
    }
}

function ShowCtrl(tag) {
    var self = this;
    self.tag = tag;
};

function CreateEditCtrl(tag ) {
    var self = this;
	
    self.tag = tag;
}

angular.module('myApp.tag.controllers', [])
    .controller('ListCtrl', ListCtrl)
    .controller('ShowCtrl', ShowCtrl)
    .controller('CreateEditCtrl', CreateEditCtrl);