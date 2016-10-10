<%--
  Starting page.
  User: Eugene
  Date: 02.02.2016
  Time: 13:11
--%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/libs/bootstrap/dist/css/bootstrap.css'/>"/>
    <title>News Fetcher</title>
</head>
    <body ng-app="NewsFetcher">

        <feed-form></feed-form>
        <feed></feed>

        <script src="<c:url value='/resources/libs/angular/angular.js'/>"></script>
        <script src="<c:url value='/resources/scripts/app.js'/>"></script>
        <script src="<c:url value='/resources/scripts/services/rssFeed.srv.js'/>"></script>
        <script src="<c:url value='/resources/scripts/controllers/rssFeed.ctrl.js'/>"></script>
        <script src="<c:url value='/resources/scripts/directives/feedForm.js'/>"></script>
        <script src="<c:url value='/resources/scripts/directives/feed.js'/>"></script>
        <script src="<c:url value='/resources/scripts/directives/feedItem.js'/>"></script>
        <script src="<c:url value='/resources/libs/jquery/dist/jquery.js'/>"></script>
        <script src="<c:url value='/resources/libs/bootstrap/dist/js/bootstrap.js'/>"></script>
</body>
</html>
