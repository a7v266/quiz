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
        <li class="nav-item active">
            <a class="nav-link" href="#">Profile <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="console">Console</a>
        </li>
    </ul>
    <form class="form-inline" action="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-primary my-2 my-sm-0" type="submit"><s:message code="{ui.navbar.logout}"/></button>
    </form>
</nav>

<div class="container pt-5 w-75 m-auto">
    <h4><span class="text-muted"><s:message code="{ui.profile.userProfile}"/></span></h4>
    <table class="table table-bordered table-striped">
        <tbody>
        <tr>
            <th class="text-nowrap" scope="row"><s:message code="{ui.profile.firstName}"/></th>
            <td><c:out value="${localUser.firstName}"/></td>
        </tr>
        <tr>
            <th class="text-nowrap" scope="row"><s:message code="{ui.profile.lastName}"/></th>
            <td><c:out value="${localUser.lastName}"/></td>
        </tr>
        <tr>
            <th class="text-nowrap" scope="row"><s:message code="{ui.profile.email}"/></th>
            <td><c:out value="${localUser.email}"/></td>
        </tr>
        <tr>
            <th class="text-nowrap" scope="row"><s:message code="{ui.profile.consumerKey}"/></th>
            <td><c:out value="${localUser.consumerKey}"/></td>
        </tr>
        <tr>
            <th class="text-nowrap" scope="row"><s:message code="{ui.profile.sharedSecret}"/></th>
            <td><c:out value="${localUser.sharedSecret}"/></td>
        </tr>
        <tr>
            <th class="text-nowrap" scope="row"><s:message code="{ui.profile.launchUrl}"/></th>
            <td><c:out value="${applicationProperties.uiLaunchUrl}"/></td>
        </tr>
        </tbody>
    </table>
</div>

<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
