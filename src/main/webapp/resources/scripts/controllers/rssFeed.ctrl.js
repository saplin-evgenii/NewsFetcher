'use strict';

App.controller('RssFeedController', ['$scope', 'RssFeedService', function ($scope, RssFeedService) {

    var self = this;

    self.originalNameToCreate = null;
    self.shortNameToCreate = null;
    self.urlToCreate = null;

    $scope.create = function () {
        RssFeedService.create(self.originalNameToCreate, self.shortNameToCreate, self.urlToCreate);
    };

    self.originalNameToGet = null;

    self.rssFeed = null;

    $scope.get = function(name) {
        RssFeedService.get(name).then(
            function (data) {
                self.rssFeed = data;
            },
            function (errResponse) {
                console.error('Error response: ' + JSON.stringify(errResponse));
                self.rssFeed = null;
            }
        );
    };

    self.rssFeeds = [];

    $scope.getAll = function () {
        RssFeedService.getAll().then(
            function (data) {
                self.rssFeeds = data;
            },
            function (errResponse) {
                console.error('Error');
            }
        );
    };


    self.originalNameToUpdate = null;
    self.shortNameToUpdate = null;
    self.urlToUpdate = null;

    $scope.update = function () {
        RssFeedService.update(self.originalNameToUpdate, self.shortNameToUpdate, self.urlToUpdate);
    };

    self.originalNameToDelete = null;

    $scope.delete = function () {
        RssFeedService.delete(self.originalNameToDelete);
    };

}]);
