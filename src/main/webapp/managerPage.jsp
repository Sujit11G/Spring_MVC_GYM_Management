<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attractive Manager Dashboard</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
  <h1>Manager Dashboard</h1>

  <a href="branchCustomers?managerId=${sessionScope.managerId}" class="btn btn-primary">All Customers</a>

  <div class="mt-4">
    <h2>Customer List</h2>
    <table class="table table-bordered">
      <thead class="thead-dark">
        <tr>
          <th>Customer_ID</th>
          <th>Name</th>
          <th>ContactNO</th>
          <th>TimeSlot</th>
          <th>Trainer_Name</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="c" items="${customers}">
          <tr>
            <td>${c.getId()}</td>
            <td>${c.getName()}</td>
            <td>${c.getContactno()}</td>
            <td>${c.getTimeSlot()}</td>
            <td>${c.getTrainer().getName()}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

  <div class="mt-4">
    <h2>Trainer List</h2>
    <table class="table table-bordered">
      <thead class="thead-dark">
        <tr>
          <th>Trainer_ID</th>
          <th>Name</th>
          <th>ContactNO</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="t" items="${trainers}">
          <tr>
            <td>${t.getId()}</td>
            <td>${t.getName()}</td>
            <td>${t.getContactNO()}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

  <div class="mt-4">
    <h2>Assign Trainer to Customer</h2>
    <form action="assignTrainerToCustomer" method="post">
      <input type="hidden" name="managerId" value="${sessionScope.managerId}"/>
      <div class="form-group">
        <label for="customerId">Customer ID:</label>
        <input type="number" id="customerId" name="customerId" class="form-control" />
      </div>
      <div class="form-group">
        <label for="trainerId">Trainer ID:</label>
        <input type="number" id="trainerId" name="trainerId" class="form-control" />
      </div>
      <button type="submit" class="btn btn-danger">Assign Trainer to Customer</button>
    </form>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
