<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
	<table class="table">
	<%
	
	User us=new User();
	us.setId(1);
	us.setFname("abc");
	us.setLname("xyz");
	us.setEmail("abc@gmail.com");
	us.setPassword("abc@123");
	
	User us1=new User();
	us.setId(2);
	us.setFname("lmn");
	us.setLname("opq");
	us.setEmail("lmn@gmail.com");
	us.setPassword("lmn@123");
	
	List<User> list=new ArrayList<User>();
	list.add(us);
	list.add(us1);
	%>
	
	<thead>
	<tr>
	<th scope="col">ID</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Email</th>
      <th scope="col">Password</th>
    </tr>
  </thead>
  <tbody>
  <%
  for(User u:list){
  %>
    <tr>
      <th scope="row"><%=u.getId() %></th>
      <td><%=u.getFname() %></td>
      <td><%=u.getLname() %></td>
      <td><%=u.getEmail() %></td>
      <td><%=u.getPassword() %></td>
    </tr>
    
    <%
  }
    %>
     </tbody>
	</table>
</body>
</html>