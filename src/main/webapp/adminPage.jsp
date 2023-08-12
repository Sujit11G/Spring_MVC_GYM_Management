 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attractive Form with Bootstrap</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
  .custom-submit-btn {
    background-color: red;
    color: yellow;
    border-radius: 0.5rem; 
  }
  .custom-anchor {
    color: blue;
    text-decoration: none;
    border-radius: 0.5rem; 
    padding: 0.5rem 1rem; 
    border: 2px solid blue; 
    transition: background-color 0.3s, color 0.3s; 
  }
  .custom-anchor:hover {
    background-color: blue;
    color: white;
  }
  .custom-bordered {
    border: 2px solid black; 
  }
</style>
</head>
<body>

<div class="container mt-5">
  <div class="row">
    <div class="col">
      <h2>BRANCH</h2>
      <div class="border p-3 custom-bordered">
        <form action="setBranch" method="post">
          <input type="hidden" name="adminId" value="${sessionScope.adminId}" /> 
          Branch Name: <br>
          <input type="text" name="branchName" class="form-control" /><br><br>
          Location: <br>
          <input type="text" name="branchLocation" class="form-control" /><br><br>
          CrossFit: 
   		 <input type="checkbox" name="facility" value="CrossFit"> <br>
   		 PowerLifting: 
   		 <input type="checkbox" name="facility" value="PowerLifting"> <br>
   		 Aerobics: 
   		 <input type="checkbox" name="facility" value="Aerobics"> <br>
   		 Yoga: 
   		 <input type="checkbox" name="facility" value="Yoga"> <br>
   		 Sauna: 
   		 <input type="checkbox" name="facility" value="Sauna"> <br>
          <input type="submit" value="Save Branch" class="btn btn-danger custom-submit-btn">
        </form>
      </div>
    </div>
  </div>
  
  <div class="row mt-4">
    <div class="col-md-6">
      <h2>MANAGER</h2>
      <div class="border p-3 custom-bordered">
        <form action="saveManager" method="post">
          <input type="hidden" name="adminId" value="${sessionScope.adminId}" /> 
          Manager Name: <br>
          <input type="text" name="managerName" class="form-control" /><br><br>
          Email: <br>
          <input type="email" name="managerEmail" class="form-control" /><br><br>
          Password: <br>
          <input type="password" name="managerPassword" class="form-control" /><br><br>
          <input type="submit" value="Save Manager" class="btn btn-danger custom-submit-btn">
        </form>
      </div>
    </div>
  </div>
  
  <div class="row mt-4">
    <div class="col">
      <a href="viewAllBranch?adminId=${sessionScope.adminId}" class="custom-anchor">View Branch</a>
    </div>
  </div>
  
  <div class="row mt-4">
    <div class="col">
      <table class="table table-bordered custom-bordered">
        <thead class="thead-dark">
          <tr>
            <th>Branch_ID</th>
            <th>Branch_Name</th>
            <th>Branch_Location</th>
            <th>Manager_ID</th>
            <th>Manager_Name</th>
            <th>Manager_Email</th>
          </tr>
        </thead>
        <tbody>
          <a:forEach var="b" items="${branches}">
            <tr>
              <td>${b.getId()}</td>
              <td>${b.getName()}</td>
              <td>${b.getLocation()}</td>
              <td>${b.manager.getId()}</td>
              <td>${b.getManager().getName()}</td>
              <td>${b.manager.getEmail()}</td>
            </tr>
          </a:forEach>
        </tbody>
      </table>
    </div>
  </div>
  
  <div class="row mt-4">
    <div class="col-md-6">
      <form action="assignBranchToManager" method="post" class="border p-4 custom-bordered">
        <input type="hidden" name="adminId" value="${sessionScope.adminId}" />
        <div class="form-group">
          <label for="branchId">Branch ID:</label>
          <input type="text" id="branchId" name="branchId" class="form-control" />
        </div>
        <div class="form-group">
          <label for="managerId">Manager ID:</label>
          <input type="text" id="managerId" name="managerId" class="form-control" />
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-danger custom-submit-btn">Assign Branch to Manager</button>
        </div>
      </form>
    </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
