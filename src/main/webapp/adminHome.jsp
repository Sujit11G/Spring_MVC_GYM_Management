<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Welcome to FitG</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background: linear-gradient(135deg, #ffbf00, #ff8000);
    }
    .card {
        background-color: #ffffcc;
    }
</style>


</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Welcome to FitG</h1>
    <div class="row">
        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-body">
                    <h2 class="text-center mb-4">Sign Up</h2>
                    <form action="adminLoad" method="get">
                        <button class="btn btn-warning btn-block">Sign Up</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card mb-4">
                <div class="card-body">
                    <h2 class="text-center mb-4">Login</h2>
                    <a href="loginadmin" class="btn btn-danger btn-block">Login</a>
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
