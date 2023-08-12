<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attractive Trainer Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
  <form action="trainerSave" method="post">
    <div class="form-group">
      <label for="name">Trainer Name:</label>
      <input type="text" id="name" name="name" class="form-control" required>
    </div>
    <div class="form-group">
      <label for="contactNO">Contact NO:</label>
      <input type="tel" id="contactNO" name="contactNO" class="form-control" required>
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" class="form-control" required>
    </div>
    <div class="form-group">
      <label for="branch">Select Branch:</label>
      <select name="branchID" class="form-control" required>
        <c:forEach items="${branches}" var="branch">
          <option value="${branch.getId()}">${branch.getLocation()}</option>
        </c:forEach>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Save Trainer</button>
  </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
