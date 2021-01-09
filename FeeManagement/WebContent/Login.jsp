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
}

.login1 {
	width: 35%;
	float: left;
	margin-top: 75px;
	margin-left: 150px;
}

.login2 {
	width: 35%;
	float: right;
	margin-top: 75px;
	margin-right: 150px;
}

h2 {
	text-align: center;
	font-style: oblique;
	font-size: 30px;
}

form {
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
	background-color: navy;
	width: 35%;
	color: white;
	height: 35px;
	font-style: italic;
	font-size: 20px;
	border-radius: 8px;
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
<title>Login Details</title>
</head>
<body>

	<div class="login1">
		<form action="adminLogin" method="post">
			<h2>Admin Login</h2>
			<input type="hidden" name="requestAction" value="adminLogin">
			<table>
				<tr>
					<th>Email</th>
					<th><input type="text" name="adminEmail"></th>
				</tr>
				<tr>
					<th>Password</th>
					<th><input type="password" name="adminPassword"></th>
				</tr>
			</table>
			<%if(request.getAttribute("message1")!=null) { %>
			<p><%=request.getAttribute("message1") %></p>
			<%} %>
			<input type="submit" class="myButton" value="Login">
		</form>
	</div>
	<div class="login2">
		<form action="accountantLogin" method="post">
			<h2>Accountant Login</h2>
			<input type="hidden" name="requestAction" value="accountantLogin">
			<table>
				<tr>
					<th>Email</th>
					<th><input type="text" name="accEmail"></th>
				</tr>
				<tr>
					<th>Password</th>
					<th><input type="password" name="accPassword"></th>
				</tr>
			</table>
			<%if(request.getAttribute("message2")!=null) { %>
			<p><%=request.getAttribute("message2") %></p>
			<%} %>
			<input type="submit" class="myButton" value="Login">
		</form>
	</div>
</body>
</html>