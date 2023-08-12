<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attractive Customer Page with Bootstrap</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
  body {
    background-color: #f8f9fa;
  }
  .custom-form {
    max-width: 500px;
    margin: auto;
    padding: 20px;
    background-color: #ffffff;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
  }
</style>
<script>
function calculateBMI() {
    var heightCm = parseFloat(document.getElementById("height").value);
    var weightKg = parseFloat(document.getElementById("weight").value);
    
    if (!isNaN(heightCm) && !isNaN(weightKg) && heightCm > 0 && weightKg > 0) {
        var heightM = heightCm / 100; 
        var bmi = weightKg / (heightM * heightM);
        document.getElementById("bmi").value = bmi.toFixed(2);
    } else {
        document.getElementById("bmi").value = "";
    }
}
</script>
</head>
<body>

<div class="container mt-5">
  <div class="row">
    <div class="col">
      <h1 class="text-center">${page}</h1>
      <h1 class="text-center">Welcome to FitG</h1>
      <form action="customerDetails" method="post" class="custom-form">
        <input type="hidden" name="customerId" value="${sessionScope.customerId}">
        
        <div class="form-group">
          <label>TimeSlot:</label>
          <div class="form-check">
            <input type="radio" name="time" value="5 AM" class="form-check-input">
            <label class="form-check-label">5AM</label>
          </div>
          <div class="form-check">
            <input type="radio" name="time" value="7 AM" class="form-check-input">
            <label class="form-check-label">7AM</label>
          </div>
          <div class="form-check">
            <input type="radio" name="time" value="9 AM" class="form-check-input">
            <label class="form-check-label">9AM</label>
          </div>
        </div>
        
        <div class="form-group">
          <label for="height">Height (CM):</label>
          <input type="number" name="height" id="height" oninput="calculateBMI()" class="form-control" placeholder="Enter Height in CM">
        </div>
        <div class="form-group">
          <label for="weight">Weight (KG):</label>
          <input type="number" name="weight" id="weight" oninput="calculateBMI()" class="form-control" placeholder="Enter Weight in Kg">
        </div>
        <div class="form-group">
          <label for="bmi">BMI:</label>
          <input type="number" name="bmi" id="bmi" readonly class="form-control">
        </div>
          <%-- <div class="form-group">
           <label>Available Facilities:</label>
          <h4>${customer.getBranch().getLocation()}</h4>
              <c:forEach items="${facilities}" var="facility">
                <label class="custom-checkbox">
                  <input type="checkbox" name="facilityID" value="${facility.getId()}">
                  ${facility.getName()}
                </label>
              </c:forEach> 
        </div>  --%>
         <div class="form-group">
          <label>Available Facilities:</label>
          <h4>${customer.getBranch().getLocation()}</h4>
            <c:forEach items="${facilities}" var="facility">
 				<label class="custom-checkbox">
                  <input type="checkbox" name="facilityID" value="${facility.getId()}">
                  ${facility.getName()}
                </label>           
            </c:forEach>
        </div> 
        
        <div class="form-group">
          <button type="submit" class="btn btn-primary">Submit</button>
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
 