<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JFSD</title>
</head>
<body>

  <h2>student details</h2>
  <%@page import="java.util.*" %>
  <%@ page import="model.StudentModel" %>
  
  <%
    @SuppressWarnings("unchecked") List<StudentModel> slist = (List<StudentModel>) request.getAttribute("studentlist");
    %>
  
  <table border="1">
  <tr>
  
    <th> id</th>
    <th> name</th>
    
    <th>Email</th>
    <th>Age</th>
    <th>Gender</th>
    </tr>
    <%
    for(StudentModel Sm : slist ) {
    %>
    <tr>
            
			<td><%= Sm.getName() %></td>
			
			<td><%= Sm.getGender() %></td>
    </tr>
    
    <% } %>
    </table>
</body>
</html>