<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1> <%=request.getParameter("name") %></h1>
	<h1> <%=request.getParameter("email") %></h1>
	<h1> <%=request.getParameter("pass") %></h1>
	
</body>
</html>