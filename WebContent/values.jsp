<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.sql.*" %>
    
     <%@ page import="com.paango.dao.CoursesDAO" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="link" class="com.paango.dao.CoursesDAO"></jsp:useBean>
  <%
  String x;
  String hidden=request.getParameter("id"); 
 link.getById(hidden); 
  %>
  
 <h1> Course Id =<%=link.getId()%><br/>
 Course Name =<%=link.getCourseName() %><br/>
 CourseDescription =<%=link.getCourseDescription()  %><br/>
 Level =<%=link.getLevel()  %> <br/>
 Prerequisites =<%=link.getPrerequisites()  %><br/>
 SkillsAcquired =<%=link.getSkillsAcquired()  %><br/>
 WhoShouldDoThisCourse =<%=link.getWhoShouldDoThisCourse()  %><br/>
 <br />
 <br /></h1>
 <h3>
 <a href="editCourse.jsp?id=<%=link.getId()%>">Edit <br>
 <a href="delete.jsp?id=<%=link.getId()%>">Delete
  </h3>
  
  
  
</body>
</html>
