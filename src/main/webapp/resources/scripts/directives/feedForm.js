'use strict';

angular.module('NewsFetcher').
    directive('feedForm', function() {
        return {
            restrict: 'E',
            replace: true,
            templateUrl: 'resources/scripts/directives/templates/feedForm.html',
            controller: function($scope) {
                $scope.name = "";
                $scope.nameLocal = "";
                $scope.submitName = function() {
                    $scope.name = $scope.nameLocal;
                }
            },
        };
    });
