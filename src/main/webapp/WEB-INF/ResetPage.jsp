<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password reset page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style type="text/css">
	header {
		background-color: silver;
		border: 2px solid black;
		padding-left: 1350px;
		font-size: 20px;
		padding-bottom: 10px;
		padding-top: 10px;
	}
	
	footer {
		background-color: silver;
		border: 2px solid black;
		padding-left: 1200px;
		font-size: 20px;
		padding-bottom: 10px;
		margin-top: 215px;
	}
	.container{
		width: 500px;
		margin-top: 100px;
		background-color: #FFEFD5;
		padding: 30px 10px;
		border-radius: 10px;
		border: 1px solid black; 
	
	}
	h5{
		margin-bottom: 20px;
		margin-top: -10px;
		font-family: Georgia;
	}
	body {
			background-color: ivory;
	}
</style>
</head>
<body>
	<header>
		<a href="goToRegister" class="btn btn-primary">Register</a> <a
			href="goToLogin" class="btn btn-primary">Login</a>
	</header>
	
	<div class="container">
		<form action="forgotPassword">
			<h5 align="center">Reset password here</h5>
			<input type="text" placeholder="E-Mail" name="mail" class="form-control">
			<label style="margin-left: 5px; font-size: 13px; color: red"> Use the same E-mail that you have used while registration</label>
			<p style="color: red ;font-size: 12px; margin-bottom: 20px ; margin-top: -1px ;padding-top: 5px">${nullMail}</p>
			<input type="password" placeholder="New password" name="NewPassword" class="form-control">
			<pre style="color: red ;font-size: 12px; margin-bottom: 20px ; margin-top: -1px ;padding-top: 5px">${nullnPswd}</pre>
			<input type="password" placeholder="Confirm new password" name="conNewPswd" class="form-control">
			<pre style="color: red ;font-size: 12px; margin-bottom: 20px ; margin-top: -1px ;padding-top: 5px">${confpaswd}</pre>
			<input type="submit" value="Reset" class="form-control btn btn-primary">
		
		</form>
	</div>
	
	<h6 style="color: red ;font-size: 15px; margin-top: 20px" align="center">${successfullReset}</h6>
	<footer align="center">footer</footer>
</body>
</html>