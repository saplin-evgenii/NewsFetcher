'use strict';

angular.module('NewsFetcher').
    directive('feed', function() {
        return {
            restrict: 'E',
            replace: true,
            templateUrl: 'resources/scripts/directives/templates/feed.html',
            controller: function($scope) {
                $scope.$watch('name', function() {
                    if (!$scope.name) {
                        return;
                    }
                    $scope.get($scope.name);
                });
            },
        }
    });
