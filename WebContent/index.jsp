<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 
</head>
<body >

<form method="post" action="values.jsp">
<input type ="text" name="id">
<input type="submit" value="Search by ID">

</br>
</br>
</form>
<form method="post" action="addcourse.jsp">
<input 	type="submit" value="Add Course">
</form>
 </body>
 
 <form method ="post">
 
 <table border="2">
 <tr><th>Edit</th><th>Delete</th><th>courseId</th><th>courseName</th><th>courseDescription</th><th>level</th><th>whoShouldDoThisCourse</th><th>prerequisites</th><th>skillsAcquired</th><th>Files</th></tr>
 
 
 
 <%
 
 try
  {
	 Class.forName("com.mysql.jdbc.Driver");
	 String url="jdbc:mysql://localhost:3306/paango";
	  String user = "root";
	  String psword = "123";
	  Connection c=null;
	  Statement s=null;
	  ResultSet rs=null;
	   c=DriverManager.getConnection(url,user,psword);
	s =c.createStatement();
	 String s1="select * from courses ";
	 rs=s.executeQuery(s1);
	 while(rs.next())
	 {
  %>
	 	 <tr><td><a href="editCourse.jsp?id=<%=rs.getInt("id") %>">Edit</td> <td><a href="delete.jsp?id=<%=rs.getInt("id") %>">Delete</td><td><%=rs.getInt("id")%></td><td><%=rs.getString("course_name") %></td><td><%=rs.getString("course_description") %></td><td><%=rs.getString("level") %><td><%=rs.getString("who_should_do_this_course") %></td><td><%=rs.getString("prerequisites") %></td><td><%=rs.getString("skills_aquired") %></td><td><a href="http://localhost:8080/lms1/Courses?id=<%=rs.getInt("id") %>">click</a></td></tr> 
	<% 
	 }
	 rs.close();
	 s.close();
	 c.close();
	 %>
	 
 </table>
 
<%
  }
 catch(Exception e)
 {
	 e.printStackTrace();
 }
 finally
 {
	
	 
 }
 %>
 </form>
 </html>
