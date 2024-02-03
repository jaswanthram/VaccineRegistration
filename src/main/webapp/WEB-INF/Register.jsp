<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style type="text/css">
	.dataSaving{
		border: 2px solid black;
		width: 600px;
		margin-left: auto;
		margin-right: auto;
		padding-left: 3%;
		padding-right: 3%;
		background-color: #FFEFD5;
		border-radius: 3px;
		margin-top: 50px;
	}
	body {
		background-color: ivory;
	}
	header{
	background-color: silver;
	border: 2px solid black;
	padding-left: 1350px;
	font-size: 20px;
	padding-bottom: 10px;
	padding-top: 10px;
}
footer{
	background-color: silver;
	border: 2px solid black;
	padding-left: 1200px;
	font-size: 20px;
	padding-bottom: 10px;
	margin-top: 335px;
}
	.alreadyExists{
		margin-top: 20px;
	}

</style>
</head>
<body>
	<header>
		<a href="goToRegister" class="btn btn-primary">Register</a>
		<a href="goToLogin" class="btn btn-primary">Login</a>
	</header>
	
	
	<div class="dataSaving">
		<form action="SaveApplication">
			<pre>
				<input type="text" name="Username" placeholder="Username" class="form-control">
				<h6 style="color: red ;font-size: 12px; margin-top: -40px; margin-bottom: -30px">${InvalidUsername}</h6>
				<input type="password" name="Password1" placeholder="Password" class="form-control">
				<h6 style="color: red ;font-size: 12px; margin-top: -40px; margin-bottom: -30px">${invalidPassword}</h6>
				<h6 style="color: red ;font-size: 12px; margin-top: -40px; margin-bottom: -30px">${mismatchpwd}</h6>
				<input type="password" name="Password2" placeholder="Confirm Password" class="form-control">
				<h6 style="color: red ;font-size: 12px; margin-top: -40px; margin-bottom: -30px">${mismatchpwd}</h6>
				<input type="tel" name="Number" placeholder="Mobile Number" class="form-control">
				<h6 style="color: red ;font-size: 12px; margin-top: -40px; margin-bottom: -30px">${Invalidnumber}</h6>
				<input type="email" name="Email" placeholder="E-Mail" class="form-control">
				<h6 style="color: red ;font-size: 12px; margin-top: -40px; margin-bottom: -20px">${Invalid}</h6>
<label style="padding:3px 37% 3px 10px; background-color: white;margin-top: 15px;border-radius: 5px"><label style="font-size: 20px">Gender</label> ---->&nbsp;&nbsp;&nbsp;<input type="radio" name="gender" value="Male"><label style="font-size: 20px">Male</label>     <input type="radio" name="gender" value="Female"><label style="font-size: 20px">Female</label></label> 
				<h6 style="color: red ;font-size: 12px; margin-top: -40px; margin-bottom: -30px">${InvalidGender}</h6>

 <label style="font-size: 20px">Date of Birth</label>&nbsp;&nbsp;&nbsp;<input type="date" name="DOB" class="form-control" >
 				<h6 style="color: red ;font-size: 12px; margin-top: -40px; margin-bottom: -30px">${InvalidDOB}</h6>
 
<h6 align="center" style="padding-top: 20px ;margin-bottom: -40px"><input type="submit" class="btn btn-success" value="Register"></h6>
			</pre>
		</form>
	</div>
	
	<h6 class="alreadyExists" align="center">Already have a account?<a href="goToLogin">Login</a></h6>
	<h3>${response}</h3>
	<footer style="border: 2px solid black; " align="center">footer</footer>
</body>
</html>