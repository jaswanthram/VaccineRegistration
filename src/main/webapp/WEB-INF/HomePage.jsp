<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style type="text/css">
body {
	background-color: ivory;
}

header {
	background-color: silver;
	padding-left :20px;
	font-size: 20px;
	padding-bottom: 10px;
	padding-top: 10px;
	height: 70px;
}

footer {
	background-color: silver;
	padding-left: 1200px;
	font-size: 20px;
	padding-bottom: 10px;
	margin-top: 600px;
	height: 70px;
}

.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: 250px;
	height: 350px;
	margin-top: 100px;
	margin-left: 100px;
	background-color: Lavender;
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.container {
	padding: 2px 16px;
}
button {
	margin-right: 1150;
}
label {
	margin-left: 1020px;
}
</style>
</head>
<body>
	<header>
		<a href="addMember" class="btn btn-primary">Add member</a>
		<label style="font-family: Poppins">Username :- ${profile}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<a href="goToLogout" class="btn btn-primary">Logout</a>
	</header>
	<h1 align="center">Welcome ${profile}</h1>

	<table align="center">
		<tr>
			<td>
			<div class="card">
				<div class="container">
				<h4>
					<b>&nbsp;&nbsp;Members count</b>
				</h4>
					<h1 align="center" style="font-size: 150px; margin-top: 25px;">${Membercount}</h1>
					<pre style="color: red ;font-size: 12px; margin-top: 80px;">You can add upto 4 members only</pre>
				</div>
			</div>
			</td>
				<td>
					<div class="card">
				<div class="container">
				<h4>
					<b>Offered Vaccine's</b>
				</h4>
				<br><br>
				<h5>-> Covishield</h5><br>
				<h5>-> Covaxin</h5><br>
				<h5>-> Novavax</h5>
				</div>
				</div>
			</td>
			
			<td>
				<div class="card">
				<div class="container">
				<h4>
					<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Doses</b>
				</h4>
				<h1 style="font-size: 150px;margin-bottom: 70px;margin-top: 20px"align="center">2</h1>
				<p>Number of mandatory doses</p>
				</div>
				</div>
			</td>
		
		</tr>
	</table>

	<footer align="center">footer</footer>


</body>
</html>