<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style type="text/css">
	.container{
		border: 1px solid black;
		padding: 20px 10px 40px 10px;
		width: 350px;
		margin-top: 150px;
		background-color: #FFEFD5;
		border-radius: 10px;
	}
	h6{
		margin-top: 30px;
	}
	.al{
		margin-top: 30px;
		margin-bottom: -20px;	
	}
	h5{
		margin-top: -10px;
		margin-bottom: 20px;
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
		margin-top: 125px;
	}
	label{
		margin-top: 20px;
		margin-bottom: -20px;
		margin-left: 110px;
	
	}
	
</style>
</head>
<body>
	<header>
		<a href="goToRegister" class="btn btn-primary">Register</a>
		<a href="goToLogin" class="btn btn-primary">Login</a>
	</header>
	<div class = "container">
		<h5 align="center">Login here</h5>
		<form action="LoginPage">
			<input type="text" placeholder="E-Mail*" name="email" class="form-control">
			<h6 style="color: red ;font-size: 12px; margin-bottom: 20px ; margin-top: -1px ;padding-top: 5px">${nullMail}</h6>
			<input type="password" placeholder="Password*" name="password" class="form-control"	>
			<h6 style="color: red ;font-size: 12px; margin-bottom: 20px ; margin-top: -1px ;padding-top: 5px">${nullPassword}</h6>
			<input type="submit" value="Login" class="btn btn-primary form-control">
			<label><a href="PasswordReset">Reset password</a></label>
		</form>
		

		<h6 class="al" style="color: red ;font-size: 15px" align="center">${attemptsleft}</h6>
		
	</div>
	<h6 style="color: red ;font-size: 15px" align="center">${blockedaccount}</h6>
	<h6 style="color: red ;font-size: 15px" align="center">${doesnotexist}</h6>
	<h6 align="center">Don't have an account?<a href="goToRegister">Sign up</a></h6>
	<footer align="center">footer</footer>
</body>
</html>