'use strict';

App.service('RssFeedService', ['$http', '$q', function ($http, $q) {

    return {

        create: function (originalNameToCreate, shortNameToCreate, urlToCreate) {
            var newRssFeed = {
                originalName: originalNameToCreate,
                shortName: shortNameToCreate,
                url: urlToCreate
            };
            return $http.post(
                'api/rssfeeds/',
                JSON.stringify(newRssFeed)
            );
        },

        get: function (originalNameToGet) {
            return $http.get('api/rssfeeds/' + originalNameToGet).then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error('Error while getting RSS feed');
                    return $q.reject(errResponse);
                }
            );
        },

        getAll: function () {
            return $http.get('api/rssfeeds/').then(
                function (response) {
                    return response.data;
                },
                function (errResponse) {
                    console.error('Error while getting RSS feeds');
                    return $q.reject(errResponse);
                }
            );
        },

        update: function (originalNameToUpdate, shortNameToUpdate, urlToUpdate) {
            var updatedRssFeed = {
                originalName: originalNameToUpdate,
                shortName: shortNameToUpdate,
                url: urlToUpdate
            };
            return $http.put(
                'api/rssfeeds/',
                JSON.stringify(updatedRssFeed)
            );
        },

        delete: function (originalNameToDelete) {
            $http.delete('api/rssfeeds/' + originalNameToDelete);
        }

    };

}]);