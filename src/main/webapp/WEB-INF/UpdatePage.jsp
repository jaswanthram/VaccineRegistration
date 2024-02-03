<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style type="text/css">
.container{
	width: 500px;
	padding : 10px;
	border: 1px solid lavender;
	border-radius:10px;
	margin-top: 20px;
	margin-bottom: 25px;
	background-color: lavender;
}
header{
	background-color: silver;
	padding-bottom: 10px;
	padding-top: 15px;
	height: 70px;
	padding-left: 10px;
}
footer{
	background-color: silver;
	padding-bottom: 10px;
	padding-top: 10px;
	height: 70px;
}
body{
background-color: ivory;
}
</style>
</head>
<body>
	<header>
		&nbsp;
	</header>
	<h3 align="center" style="color: red">Fields should not be empty</h3>
	<div class="container">
		<form action="${pageContext.request.contextPath}/updateData">
		
			<input type="number" value="${changeID}" name="changeID" class="form-control" readonly><br>
			<input type="text" value="${changeName}" name="nameChange" class="form-control"><br>
			<input type="text" value="${changeGender}" name="GenderChange" class="form-control" readonly><br>
			<input type="text" value="${changeBirthDay}" name="BDayChange" class="form-control"><br>
			<input type="text" value="${changeIdproof}" name="ProofChange" class="form-control" readonly><br>
			<input type="text" value="${changeIdproofNumber}" name="ProofNumberChange" class="form-control"><br>
			<input type="text" value="${changeVaccine}" name="vaccineChange" class="form-control" readonly><br>
			<input type="text" value="${changeDoseType}" name="DoseChange" class="form-control" readonly><br>
			<input type="submit" value="EDIT" class="btn btn-primary">
		</form>
	</div>
	
	
	<footer>&nbsp;</footer>	
</body>
</html>