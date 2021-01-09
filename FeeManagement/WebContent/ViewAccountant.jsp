<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*, com.project.Beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewAccountants</title>
<style>
body {
	text-align: center;
	font-size: 25px;
	font-style: italic;
}
.design1 {
    width: 75%;
    background-color: #E0F7FA;
    margin: auto;
    padding: 35px;
    border: 2px dashed black;
    border-radius: 30px;
    position: absolute;
    top: 45%;
    left: 50%;
    transform: translate(-50%, -50%);}
    
table {
    border-spacing: 0px;
    width: 100%;
    margin: auto;
    border: 1px solid;
    font-size: 20px;
}

.myButton {
	background-color: #F44336;
    width: 16%;
    color: white;
    height: 39px;
	font-style: italic;
	font-size: 20px;
	border-radius: 8px;
	margin-top: 30px;
}

.logoutButton {
	background-color: #F44336;
    width: 17%;
    color: white;
    height: 39px;
	font-style: italic;
	font-size: 20px;
	border-radius: 8px;
}
</style>
</head>
<body>
<div class="design1">
	<h2 style="margin-top: 0px;color: #E91E63;">View Accountant</h2>
	<%
		List<Accountant> listOfAllAccountants = (ArrayList<Accountant>) request
				.getAttribute("listOfAllAccountants");
	%>
	<table border=1>
		<tr style = "color: #3F51B5;">
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Contact</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			for (Accountant accountant : listOfAllAccountants) {
		%>
		<tr>
			<td><%=accountant.getAccName()%></td>
			<td><%=accountant.getAccEmail()%></td>
			<td><%=accountant.getAccPassword()%></td>
			<td><%=accountant.getAccContact()%></td>
			<td><a
				href="updateAccountantForm?requestAction=updateFormAccountant&accEmail=<%=accountant.getAccEmail()%>">Edit</a>
			</td>
			<td><a
				href="deleteAccountant?requestAction=deleteAccountant&accEmail=<%=accountant.getAccEmail()%>">Delete</a>
			</td>
			<%
				}
			%>
		</tr>

	</table>
	<br>
	<form action="logoutadmin">
	<input type="submit" class="logoutButton" name = "requestAction" value="Logout Admin">
	<input type="submit" class="logoutButton" name = "requestAction" value="Admin Panel">
	</form>
</div>
</body>
</html>