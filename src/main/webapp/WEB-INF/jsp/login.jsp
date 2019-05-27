<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Quiz</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
</head>

<body>

<c:if test="${param.error != null}">
    <div class="alert alert-danger" role="alert">
        Invalid username and password!
    </div>
</c:if>

<c:if test="${param.logout != null}">
    <div class="alert alert-success" role="alert">
        You have been logged out.
    </div>
</c:if>

<div class="container">

    <div class="text-center">
        <h2>Sign In</h2>
    </div>

    <form class="form-login needs-validation" action="login" method="post">

        <div class="row">
            <div class="col-md-12 mb-3">
                <input type="text" class="form-control" id="username" name="username" placeholder="Username" required
                       autofocus>
                <div class="invalid-feedback" style="width: 100%;">
                    Your username is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 mb-3">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password"
                       required>
                <div class="invalid-feedback">
                    Please enter your password.
                </div>
            </div>
        </div>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button class="btn btn-primary btn-lg btn-block mt-2" type="submit">Sign In</button>

        <div class="mt-3 text-center">
            <a class="nav-link" href="registration">Registration</a>
        </div>

    </form>

</div>

<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
