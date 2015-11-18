<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    
     <%@ page import="com.paango.dao.CoursesDAO" %>
    
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head >
<style type="text/css" >
span
{
color:red;
}</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

 
  
  
<body>

 
 
 
 </body>
 <form name="addcourse" method="POST" action="Courses">


<h1>Course Id<span>*</span>:</h1>
<input  type="text" name="cid" id="cid"   required>

  <br>
  
<h1>Course Name<span>*</span>:</h1>
<input  type="text" name="cname" id="cname"  required>

  <br>

<h1>Course Description<span>*</span>:</h1>
<input  type="text" name="cdesc" id="cdesc"   required>
 
 <br>
<h1>level<span>*</span>:</h1>
<select name="level" id="level"  required>
<option value="beginner">beginner</option>
<option value="intermediate">intermediate</option>
<option value="advanced">advanced</option>

 
</select>
 
 <br>
<h2>Who should do this course?:</h2>
 <textarea   name="tarea1" id="tarea1"></textarea>
 
  <br />
<h2>What are the prerequisites?:</h2>
 <textarea rows="5" cols="5" name="tarea2" id="tarea2" ></textarea>
 
  <br>
<h2>Skills acquired in this course<span>*</span>:</h2>
<textarea rows="5" cols="5" name="tarea3" id="tarea3"  required></textarea>
 <br />
  <br />
   <br>
 
 <input type="hidden" name="hidden" id="hidden"   />
  <a href="http://localhost:8080/lms1/Courses?id=<%=request.getParameter("id")%>">Attached file</a>
  <br/>
  <input type="hidden" name="type1" value="E">
 <input type="submit" value="Update Course">
 
 
 </form>
 
 
 <p id="cou"> </p>
 
 
 <jsp:useBean id="link" class="com.paango.dao.CoursesDAO"></jsp:useBean>
  <%
  String x;
  String hidden=request.getParameter("id"); 
 link.getById(hidden); 
  %>
 
  
 
   <script type="text/javascript">
 document.getElementById("cid").value="<%=link.getId()%>";
 document.getElementById("cname").value="<%=link.getCourseName() %>";
 document.getElementById("cdesc").value="<%=link.getCourseDescription()  %>";
 document.getElementById("level").value="<%=link.getLevel()  %>";
 document.getElementById("tarea2").value="<%=link.getPrerequisites()  %>";
 document.getElementById("tarea3").value="<%=link.getSkillsAcquired()  %>";
 document.getElementById("tarea1").value="<%=link.getWhoShouldDoThisCourse()  %>";

 </script>
 
 
 
 <script type="text/javascript">
 
  
 
 

			 
		   
  </script>
  
  
 
</html>
