<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Customer Registration Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
  .custom-form {
    max-width: 100%;
    padding: 20px;
    background-color: #f8f9fa;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  }
  .custom-checkbox {
    display: block;
    margin-bottom: 10px;
  }
</style>
</head>
<body>

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-8">
          <h2 class="text-center">Customer Form</h2>
    
      <form action="customeradd" method="post" class="custom-form">
        <div class="form-group">
          <label for="name">Customer Name:</label>
          <input type="text" id="name" name="name" class="form-control" required>
        </div>
        <div class="form-group">
          <label for="contactno">Contact No:</label>
          <input type="tel" id="contactno" name="contactno" class="form-control" required>
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
         <div class="form-group">
          <label>Available Facilities:</label>
          <c:forEach items="${branches}" var="branch">
            <c:if test="${branch != null}">
              <h4>${branch.getLocation()}</h4>
              <c:forEach items="${branch.getFacilities()}" var="facility">
                <label class="custom-checkbox">
                  <input type="checkbox" name="facilityID" value="${facility.getId()}">
                  ${facility.getName()}
                </label>
              </c:forEach>
            </c:if>
          </c:forEach>
        </div> 
        <button type="submit" class="btn btn-primary">Save Customer</button>
      </form>
    </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
