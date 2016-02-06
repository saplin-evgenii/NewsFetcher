<%--
  Starting page.
  User: Eugene
  Date: 02.02.2016
  Time: 13:11
--%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RSS feeds</title>
</head>
<body ng-app="myApp">

<div ng-controller="RssFeedController as ctrl" ng-init="getAll()">
    <fieldset>
        <legend>Create RSS feed</legend>
        <label for="originalNameToCreate">Original name: </label>
        <input type="text" ng-model="ctrl.originalNameToCreate" id="originalNameToCreate"/>
        <label for="shortNameToCreate">Short name: </label>
        <input type="text" ng-model="ctrl.shortNameToCreate" id="shortNameToCreate"/>
        <label for="urlToCreate">URL: </label>
        <input type="text" ng-model="ctrl.urlToCreate" id="urlToCreate"/>
        <input type="button" ng-click="create()" value="Submit"/>
    </fieldset>

    <fieldset>
        <legend>Update RSS feed</legend>
        <label for="originalNameToUpdate">Original name: </label>
        <input type="text" ng-model="ctrl.originalNameToUpdate" id="originalNameToUpdate"/>
        <label for="shortNameToUpdate">Short name: </label>
        <input type="text" ng-model="ctrl.shortNameToUpdate" id="shortNameToUpdate"/>
        <label for="urlToUpdate">URL: </label>
        <input type="text" ng-model="ctrl.urlToUpdate" id="urlToUpdate"/>
        <input type="button" ng-click="update()" value="Submit"/>
    </fieldset>

    <fieldset>
        <legend>Get RSS feed</legend>
        <label for="originalNameToGet">Original name: </label>
        <input type="text" ng-model="ctrl.originalNameToGet" id="originalNameToGet"/>
        <label for="shortNameToGet">Short name: </label>
        <input type="text" ng-model="ctrl.rssFeed.shortName" id="shortNameToGet" disabled="disabled"/>
        <label for="urlToGet">URL: </label>
        <input type="text" ng-model="ctrl.rssFeed.url" id="urlToGet" readonly disabled="disabled"/>
        <input type="button" ng-click="get()" value="Submit"/>
    </fieldset>

    <fieldset>
        <legend>Get all RSS feeds</legend>
        <div ng-repeat="rssFeed in ctrl.rssFeeds">
            <label for="originalName">Original name: </label>
            <input type="text" ng-model="rssFeed.originalName" id="originalName" readonly disabled="disabled"/>
            <label for="shortName">Short name: </label>
            <input type="text" ng-model="rssFeed.shortName" id="shortName" readonly disabled="disabled"/>
            <label for="url">URL: </label>
            <input type="text" ng-model="rssFeed.url" id="url" readonly disabled="disabled"/>
        </div>
    </fieldset>

    <fieldset>
        <legend>Delete RSS feed</legend>
        <label for="originalNameToDelete">Name:</label>
        <input type="text" ng-model="ctrl.originalNameToDelete" id="originalNameToDelete"/>
        <input type="button" ng-click="delete(ctrl.originalNameToDelete)" value="Submit"/>
    </fieldset>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/resources/scripts/app.js'/>"></script>
<script src="<c:url value='/resources/scripts/services/rssFeed.srv.js'/>"></script>
<script src="<c:url value='/resources/scripts/controllers/rssFeed.ctrl.js'/>"></script>
</body>
</html>