<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attractive Login Form with Bootstrap</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
  .custom-form {
    max-width: 400px;
    margin: auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  }
  .custom-submit-btn {
    background-color: #007bff;
    color: white;
    border-radius: 5px;
  }
  .custom-submit-btn:hover {
    background-color: #0056b3;
  }
</style>
</head>
<body>

<div class="container mt-5">
  <h1 class="text-center mb-4">Customer Login</h1>

  <div class="row justify-content-center">
    <div class="col-md-6">
      <c:if test="${not empty authMessage}">
        <p style="color: red;">${authMessage}</p>
      </c:if>
      <div class="custom-form">
        <form:form action="loginCustomer" modelAttribute="login1">
          <div class="form-group">
            <label for="customerId">ID:</label>
            <form:input path="id" placeholder="Enter ID" name="customerId" class="form-control" />
          </div>
          <div class="form-group">
            <label for="password">Password:</label>
            <form:input path="password" placeholder="Enter Password" class="form-control" />
          </div>
          <div class="form-group">
            <input type="submit" value="Login" class="btn btn-primary custom-submit-btn">
          </div>
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
