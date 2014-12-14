<%@page import="com.students.bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<%
ArrayList<Student> l=(ArrayList<Student>)request.getAttribute("stddetails");
for(int i=0;i<l.size();i++)
{
%><tr><td>
<%=l.get(i).getId() %></td><td>
<%=l.get(i).getFname() %></td><td>
<%=l.get(i).getLname() %></td><td>
<%=l.get(i).getMarks() %></td>
<td><a href="editStudentController?id=<%=l.get(i).getId()%>">EDIT</a></td>
<td><a href="deleteStudentController?id=<%=l.get(i).getId()%>">DELETE</a></td></tr>
<%} %>
</table>
</body>
</html>