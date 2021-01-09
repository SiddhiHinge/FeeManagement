<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.project.Beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Student</title>
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
	margin-top: 30px;
	background-color: navy;
	width: 50%;
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

.logoutButton {
	background-color: #F44336;
    width: 46%;
    color: white;
    height: 39px;
	font-style: italic;
	font-size: 20px;
	border-radius: 8px;
	margin-top: 30px;
}

select {
	font-size: 15px;
	width: 100%;
	height: 30px;
}

table {
	border-spacing: 10px;
}
</style>
</head>

<body>
<% Student student=(Student)request.getAttribute("student"); %>
<h2>Edit Student Form</h2>
	<form action="updateStudent">
		<input type="hidden" name="requestAction" value="updateStudent" />
		<table>
			<tr>
			<td>Student Name:</td>
			<td><input type="text" name="studName" value="<%=student.getStudName()%>" /></td>
			</tr>
			
			<tr>
			<td>Roll No:</td>
			<td><input type="text" name="studRoll" value="<%=student.getStudRoll()%>" /></td>
			</tr>
			
			<tr>
			<td> Gender:</td>
			<td>Male <input type="radio" name="studGender" value="Male" <%if(student.getStudGender().equalsIgnoreCase("male")){%>checked<%}%>  />
			Female<input type="radio" name="studGender" value="Female" <%if(student.getStudGender().equalsIgnoreCase("female")){%>checked<%} %>/>
			</td>
			</tr>
			
			<tr>
			<td>Contact Number:</td>
			<td><input type="text" name="studContact" value="<%=student.getStudContact()%>" /></td>
			</tr>
			
			<tr>
			<td>Email Id:</td>
			<td><input type="text" name="studEmail" value="<%=student.getStudEmail()%>" /></td>
			</tr>
			
			<tr>
			<td>Course:</td>
			<td>
			<select name="studCourse">
				<option value="Java" label="Java" <%if(student.getStudCourse().equalsIgnoreCase("Java")){%>selected<%} %>  />
				<option value="Python" label="Python" <%if(student.getStudCourse().equalsIgnoreCase("Python")){%>selected<%} %> />
				<option value=".Net" label=".Net" <%if(student.getStudCourse().equalsIgnoreCase(".Net")){%>selected<%} %> />
				<option value="C++" label="C++" <%if(student.getStudCourse().equalsIgnoreCase("C++")){%>selected<%} %> />
				<option value="C#" label="C#" <%if(student.getStudCourse().equalsIgnoreCase("C#")){%>selected<%} %> />
				</select>
			</td>
			</tr>
			
			<tr>
			<td>Total Fee:</td>
			<td><input type="text" name="studTotalFee" value="<%=student.getStudTotalFee()%>" /></td>
			</tr>
			
			<tr>
			<td>Paid Fee:</td>
			<td><input type="text" name="studPaidFee" value="<%=student.getStudPaidFee()%>" /></td>
			</tr>
			
		</table>
		<input type="submit" class="myButton" value="Edit Student" />
		<%
			if (request.getAttribute("message") != null) {
		%>
		<p><%=request.getAttribute("message")%></p>
		<%
				}
		%>
		<br><br>
		<input type="submit" class="logoutButton" name="requestAction"
				value="Accountant Panel">
	</form>
</body>
</html>