<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Quiz</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/registration.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container">

    <div class="text-center">
        <h2>Registration</h2>
    </div>

    <form class="form-registration needs-validation" action="registration" method="post">

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="firstName">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" value="" required
                       autofocus>
                <div class="invalid-feedback">
                    Valid first name is required.
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label for="lastName">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" value="" required>
                <div class="invalid-feedback">
                    Valid last name is required.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
                <div class="invalid-feedback" style="width: 100%;">
                    Your username is required.
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label for="email">Email <span class="text-muted">(Optional)</span></label>
                <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com">
                <div class="invalid-feedback">
                    Please enter a valid email address for shipping updates.
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password1">Password</label>
                <input type="password" class="form-control" id="password1" name="password1" placeholder="Password"
                       required>
                <div class="invalid-feedback">
                    Please enter your password.
                </div>
            </div>
            <div class="col-md-6 mb-3">
                <label for="password2">Password</label>
                <input type="password" class="form-control" id="password2" name="password2" placeholder="Password"
                       required>
                <div class="invalid-feedback">
                    Please reenter your password.
                </div>
            </div>
        </div>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button class="btn btn-primary btn-lg btn-block mt-2" type="submit">Register</button>

        <div class="mt-3 text-center">
            <a class="nav-link" href="login">Log In</a>
        </div>

    </form>
</div>

<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="js/registration.js"></script>
</body>
</html>