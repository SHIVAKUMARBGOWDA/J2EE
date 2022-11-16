<%@page import="DTO1.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	User u=(User)request.getAttribute("user");
	
	%>
	<h1>USER DETAILS</h1>
	<table border="2px">
	
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>EMAIL</th>
		<th>PHONE NUMBER</th>	
	</tr>
	<tr style="background-color:yellow" >
		<td><%=u.getId()%></td>
		<td><%=u.getName()%></td>
		<td><%=u.getEmail()%></td>
		<td><%=u.getPhone()%></td>
	</tr>
	</table>
</body>
</html>