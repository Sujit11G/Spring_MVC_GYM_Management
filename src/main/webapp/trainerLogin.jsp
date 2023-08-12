<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trainer Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background: linear-gradient(135deg, #ffbf00, #ff8000);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .login-container {
        background-color: #ffffcc;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        width: 100%;
        text-align: center;
    }
</style>
</head>
<body>
<div class="login-container">

    <h2 class="mb-4">Trainer Login</h2>
    <c:if test="${not empty authMessage}">
        <p class="text-danger">${authMessage}</p>
    </c:if>
    <form:form action="trainerLogin" modelAttribute="tLogin">
        <div class="form-group">
        <label for="trainerId">ID:</label>
        <form:input type="id" path="id" name="trainerId" class="form-control" />
    </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <form:input type="password" path="password" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-warning btn-block">Login</button>
    </form:form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
