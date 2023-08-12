<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
  body {
    background-color: #f8f9fa;
  }
  .container {
    margin-top: 100px;
  }
  .custom-form {
    padding: 20px;
    border: 1px solid #d3d3d3;
    border-radius: 10px;
    background-color: white;
  }
  .custom-input {
    width: 100%;
    padding: 10px;
    border: 1px solid #d3d3d3;
    border-radius: 5px;
  }
  .custom-submit-btn {
    display: block;
    width: 100%;
    padding: 10px;
    background-color: blue;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
</style>
</head>
<body>

<div class="container">
  <h1 class="text-center mb-4">Manager Login</h1>

  <div class="row justify-content-center">
  <br>
    <div class="col-md-6">
      <div class="custom-form">
        <c:if test="${not empty authMessage}">
          <p style="color: red;">${authMessage}</p>
        </c:if>
        <form:form action="loginManager" modelAttribute="mLogin">
          <label for="id">ID:</label><br>
          <form:input path="id" id="id" class="custom-input" placeholder="Enter ID" name="managerId" /><br><br>
          <label for="password">Password:</label><br>
          <form:input path="password" id="password" class="custom-input" placeholder="Enter Password" /><br><br>
          <input type="submit" value="Login" class="custom-submit-btn">
        </form:form>
      </div>
    </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
