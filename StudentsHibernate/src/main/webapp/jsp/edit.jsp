<%@page import="com.students.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/editStudentController" method="post">
		<table align="center" border="2">
		<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="<%=((Student)request.getAttribute("st")).getId() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname" value="<%=((Student)request.getAttribute("st")).getFname() %>"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname" value="<%=((Student)request.getAttribute("st")).getLname() %>"></td>
			</tr>
			<tr>
				<td>Marks</td>
				<td><input type="text" name="marks" value="<%=((Student)request.getAttribute("st")).getMarks() %>"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>