<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
  .custom-btn {
    display: inline-block;
    margin: 10px;
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    text-decoration: none;
    cursor: pointer;
  }
</style>
</head>
<body>

<div class="container mt-5 text-center">
  <h1>Welcome to FitG</h1>
  
  <div class="row">
    <div class="col-md-6">
      <a href="customerload" class="btn btn-primary custom-btn">Customer Sign Up</a>
      <a href="customer" class="btn btn-primary custom-btn">Customer Login</a>
    </div>
    <div class="col-md-6">
      <a href="trainerload" class="btn btn-primary custom-btn">Trainer Sign Up</a>
      <a href="loginTrainer" class="btn btn-primary custom-btn">Trainer Login</a>
    </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
