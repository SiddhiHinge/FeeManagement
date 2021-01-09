<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.project.Beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
    width: 35%;
    color: white;
    height: 39px;
	font-style: italic;
	font-size: 20px;
	margin-top: 20px;
	border-radius: 8px;
}

</style>
<title>ViewStudentDue</title>
</head>
<body>
<div class="design1">
	<h2>View Due Fees Students</h2>

	<%ArrayList<Student> listOfAllStudents = (ArrayList<Student>) request.getAttribute("listOfAllStudents"); %>

	<table border="1">
		<tr style="color: #3F51B5;">
			<th>Name</th>
			<th>Roll No</th>
			<th>Gender</th>
			<th>Contact</th>
			<th>Email</th>
			<th>Course</th>
			<th>Total Fees</th>
			<th>Paid Fees</th>
			<th>Due Fees</th>
		</tr>
		<%
			for (Student student : listOfAllStudents) {
		%>
		<tr>
			<td><%=student.getStudName() %></td>
			<td><%=student.getStudRoll() %></td>
			<td><%=student.getStudGender() %></td>
			<td><%=student.getStudContact() %></td>
			<td><%=student.getStudEmail() %></td>
			<td><%=student.getStudCourse() %></td>
			<td><%=student.getStudTotalFee() %></td>
			<td><%=student.getStudPaidFee() %></td>
			<td><%=student.getStudDueFee() %></td>
			<% } 
		%>
		</tr>
	</table>

	<form action="logoutAccountant">
		<input type="submit" class="logoutButton" name = "requestAction" value="Logout Accountant">
		<input type="submit" class="logoutButton" name = "requestAction" value="Accountant Panel">
</form>
</div>
</body>
</html>