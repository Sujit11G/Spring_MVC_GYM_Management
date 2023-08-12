<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attractive Form with Bootstrap</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card border border-dark">
        <div class="card-header bg-primary text-white">
          <h4 class="text-center">Admin Form</h4>
        </div>
        <div class="card-body">
          <form:form action="adminSave" modelAttribute="admin">
            <div class="form-group">
              <label for="name">Name:</label>
              <form:input path="name" class="form-control" />
              <div class="invalid-feedback">Please provide a name.</div>
            </div>
            <div class="form-group">
              <label for="email">Email:</label>
              <form:input path="email" type="email" class="form-control" />
              <div class="invalid-feedback">Please provide a valid email.</div>
            </div>
            <div class="form-group">
              <label for="password">Password:</label>
              <form:input path="password" type="password" class="form-control" />
              <div class="invalid-feedback">Please provide a password.</div>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
          </form:form>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
