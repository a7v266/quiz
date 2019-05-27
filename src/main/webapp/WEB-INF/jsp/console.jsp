<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><s:message code="{ui.applicationName}"/></title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand navbar-light bg-light justify-content-between">
    <a class="navbar-brand"><s:message code="{ui.applicationName}"/></a>
    <ul class="navbar-nav mr-auto mt-lg-1">
        <li class="nav-item">
            <a class="nav-link" href="profile">Profile</a>
        </li>
        <li class="nav-item  active">
            <a class="nav-link" href="#">Console <span class="sr-only">(current)</span></a>
        </li>
    </ul>
    <form class="form-inline" action="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-primary my-2 my-sm-0" type="submit"><s:message code="{ui.navbar.logout}"/></button>
    </form>
</nav>

<div class="input-group">
    <input type="text" id="url" class="form-control" aria-describedby="button-addon4">
    <div class="input-group-append" id="button-addon4">
        <button class="btn btn-outline-secondary" type="button" onclick="executeRequest('GET')">GET</button>
        <button class="btn btn-outline-secondary" type="button" onclick="executeRequest('POST')">POST</button>
        <button class="btn btn-outline-secondary" type="button" onclick="executeRequest('PUT')">PUT</button>
        <button class="btn btn-outline-secondary" type="button" onclick="executeRequest('DELETE')">DELETE</button>
    </div>
</div>

<div class="input-group">
    <textarea id="requestParameters" class="form-control" rows="3"></textarea>
</div>
<div class="input-group">
    <textarea id="requestBody" class="form-control" rows="5"></textarea>
</div>
<div class="input-group">
    <textarea id="response" class="form-control" rows="20"></textarea>
</div>

<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="js/console.js"></script>
</body>
</html>
