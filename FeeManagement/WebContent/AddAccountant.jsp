<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
	text-align: center;
	font-size: 20px;
	font-style: italic;
	position: absolute;
	top: 45%;
	left: 50%;
	transform: translate(-50%, -50%);
}

h2 {
	text-align: center;
	font-style: oblique;
	font-size: 30px;
}

.myForm {
	width: 90%;
	margin: auto;
	padding: 35px;
	border-radius: 15px;
	background-color: #E0F7FA;
}

p {
	color: red;
	font-size: 20px;
}

.myButton {
	margin-top: 30px;
	background-color: navy;
	width: 50%;
	color: white;
	height: 35px;
	font-style: italic;
	font-size: 20px;
	border-radius: 8px;
}

.logoutButton {
	background-color: #F44336;
    width: 40%;
    color: white;
    height: 39px;
	font-style: italic;
	font-size: 20px;
	border-radius: 8px;
	margin-top: 15px;
}

input {
	font-family: monospace;
	font-size: 18px;
	text-align: center;
}

table {
	border-spacing: 10px;
}
</style>

<title>AddAccountantPage</title>
<body>
	<form class="myForm" action="addAccountant" method="post">
		<h2>Add Accountant Form</h2>
		<input type="hidden" name="requestAction" value="addAccountant">
		<table>

			<tr>
				<th>Name</th>
				<td><input type="text" name="accName" /></td>
			</tr>
			<tr>
				<th>Email-ID</th>
				<td><input type="text" name="accEmail" /></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="accPassword" /></td>
			</tr>
			<tr>
				<th>Contact No.</th>
				<td><input type="text" name="accContact" /></td>
			</tr>
		</table>
		<input type="submit" class="myButton" value="Add Accountant" />
		<%
			if (request.getAttribute("message") != null) {
		%>
	<p><%=request.getAttribute("message")%></p>
	<%
				}
		%>
	</form>
	<form action="logoutadmin">
	<input type="submit" class="logoutButton" name = "requestAction" value="Logout Admin">
	<input type="submit" class="logoutButton" name = "requestAction" value="Admin Panel">
	</form>
</body>
</html>