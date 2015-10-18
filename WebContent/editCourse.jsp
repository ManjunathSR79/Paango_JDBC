<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.paango.dao.CoursesDAO" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css" >
span
{
color:red;
}</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

 <form name="Editcourse" method="post" action="Courses">

<h1>Course Name<span>*</span>:</h1>
<input  type="text" name="cname" id="cname" required>

  <br>

<h1>Course Description<span>*</span>:</h1>
<input  type="text" name="cdesc" id="cdesc"  required>
 
 <br>
<h1>level<span>*</span>:</h1>
<select name="level" id="level"  required>
<option value="beginner">beginner</option>
<option value="intermediate">intermediate</option>
<option value="advanced">advanced</option>
</select>
 
 <br>
<h2>Who should do this course?:</h2>
 <textarea   name="tarea1" id="tarea1" ></textarea>
 
  <br />
<h2>What are the prerequisites?:</h2>
 <textarea rows="5" cols="5" name="tarea2" id="tarea2"  ></textarea>
 
  <br>
<h2>Skills acquired in this course<span>*</span>:</h2>
<textarea rows="5" cols="5" name="tarea3" id ="tarea3" required></textarea>
 <br />
  <br />
   <br>
 
   <input type="hidden" name="hidden" id="hidden" value='<%=request.getParameter("id")%>' />
  <input type="hidden" name="revision" id="revision" value='<%=request.getParameter("rev")%>'  />
  <input type="hidden" name="type" value="E">
 <input type="submit" value="Update Course">
 
 <p id="course"></p>
 </form>
 
<jsp:useBean id="link" class="com.paango.dao.CoursesDAO"></jsp:useBean>
  <%
  String x;
  String hidden=request.getParameter("id"); 
  x=link.getById(hidden); 
  %>
   
  
  <script type="text/javascript">
      var xx='<%=x%>';
      var  mycourses = JSON.parse(xx);
             document.getElementById("cname").value = mycourses.courseName;
             document.getElementById("cdesc").value = mycourses.courseDescription;
             document.getElementById("level").value = mycourses.level;
             document.getElementById("tarea2").value = mycourses.prerequisites;
             document.getElementById("tarea3").value = mycourses.skillsAcquired;
             document.getElementById("tarea1").value = mycourses.whoShouldDoThisCourse;
    
  </script>
 	
 </body>
</html>
