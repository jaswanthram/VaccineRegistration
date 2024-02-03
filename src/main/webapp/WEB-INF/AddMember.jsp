<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Members</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top:50px;
	width: 500px;
	border: 1px solid black;
	padding : 20px  ;
	border-radius: 10px;
	margin-bottom: 83px;
	background-color: #FFB6C1;
	margin-left: 20px;
	margin-right: 0px;
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
h2{
	font-family:"Poppins";
	margin-left: 50px;
}
.tableClass{
	font-size: 17px;
	font-family: Poppins;
	width: 950px;
	margin-left: 20px;
}
.tableClass th{
  	border-collapse: collapse;
  	padding : 5px;
}
.tableClass td{
	background-color: #96D4D4;
	border: 2px solid white;
  	border-collapse: collapse;
  	padding: 5px;
}
.deleteData{
	padding-left: 100px;
}

</style>
</head>
<body>
	<header>
		<a class="btn btn-primary" href="ViewAllMembers">View Members</a>
	</header>
	
	<h2 align="center">"With infectious disease,without vaccines, there’s no safety in numbers"</h2>
	
	<table >
		<tr>
		<td>
		<table class="tableClass">
		<tr>
				<th>${membername}&nbsp;&nbsp;</th>
				<th>${gender}&nbsp;&nbsp;</th>
				<th>${dob}&nbsp;&nbsp;</th>
				<th>${Idproof}&nbsp;&nbsp;</th>
				<th>${proofno}&nbsp;&nbsp;</th>
				<th>${typeofvacc}&nbsp;&nbsp;</th>
				<th>${dose}&nbsp;&nbsp;</th>
				<th>${editData}&nbsp;&nbsp;</th>
				<th>${deleteData}&nbsp;&nbsp;</th>
				
			</tr>
		<c:forEach items="${allData}" var="members">
			<tr>
				<td>${members.name}&nbsp;&nbsp;</td>
				<td>${members.gender}&nbsp;&nbsp;</td>
				<td>${members.dob}&nbsp;&nbsp;</td>
				<td>${members.idProof}&nbsp;&nbsp;</td>
				<td>${members.proofNumber}&nbsp;&nbsp;</td>
				<td>${members.vaccineType}&nbsp;&nbsp;</td>
				<td>${members.dose}&nbsp;&nbsp;</td>
				<td><a href="goToEditPage/${members.id}">Edit</a></td>
				<td><a style="color: red" href="deleteTheMember/${members.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</td>
			<td><div class="container">
		<h5 align="center">Add here</h5>
		<form action="addTheMember">
			<input type="text" name="name" placeholder="Member Name*" class="form-control"><br>
			<p style="color: red;font-size: 12px;margin-top: -20px;">${nameisnull}</p>
			
			<p style="background-color: white; height: 35px; padding-top: 5px; border-radius: 5px;">&nbsp;&nbsp;Gender*&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="Male" name="gender">&nbsp;&nbsp;Male&nbsp;&nbsp;&nbsp;
			<input type="radio" value="Female" name="gender">&nbsp;&nbsp;Female<br><br></p>
			
			Date of Birth*<input type="date" name="dob" class="form-control"><br>
   			<p style="color: red;font-size: 12px;margin-top: -20px;">${Dobisnull}</p>
   			
			ID-Proof*
			  <select class="form-control" name="IdProof">
			  	<option>Aadhar Card</option>
			  	<option>PAN Card</option>
			  	<option>Voter ID</option>
			  	<option>Passport</option>
			  	<option>Driving Liscence</option>
			  </select><br>
			
			<input type="text" name="IdProofNumber" placeholder="Id proof Number*" class="form-control"><br>
			<p style="color: red;font-size: 12px;margin-top: -20px;">${IdproofNumNull}</p>
			
			<p style="background-color: white; height: 35px; padding-top: 5px; border-radius: 5px">&nbsp;&nbsp;Vaccine Type*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="covishield" name="Vaccinetype">Covishield&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="covaxine" name="Vaccinetype">Covaxine&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="novavax" name="Vaccinetype">Novavax</p>
			
			Dosage*
			<select class="form-control" name="dose">
				<option>Dose 1</option>
				<option>Dose 2</option>
				<option>Dose 3</option>
			</select>
			<br>
			
			<input type="submit" value="Add" class="btn btn-primary">
		</form>
		<h5 align="center" style="color: red; margin-top: 10px;">${overloading}</h5>
	</div>
	</td>
		</tr>
	</table>
	
	<h3>${response}</h3>
	<h4>${updateLogic}</h4>
	<footer>&nbsp;</footer>	
</body>
</html>