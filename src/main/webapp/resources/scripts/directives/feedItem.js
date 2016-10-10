'use strict';

angular.module('NewsFetcher').
    directive('feedItem', function() {
        return {
            restrict: 'E',
            replace: true,
            templateUrl: 'resources/scripts/directives/templates/feedItem.html',
        }
    });
