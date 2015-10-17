<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     
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

 <form name="addcourse" method="POST" action="Courses">

<h1>Course Name<span>*</span>:</h1>
<input  type="text" name="cname"  required>

  <br>

<h1>Course Description<span>*</span>:</h1>
<input  type="text" name="cdesc"  required>
 
 <br>
<h1>level<span>*</span>:</h1>
<select name="level"   required>
<option value="beginner">beginner</option>
<option value="intermediate">intermediate</option>
<option value="advanced">advanced</option>
</select>
 
 <br>
<h2>Who should do this course?:</h2>
 <textarea   name="tarea1" ></textarea>
 
  <br />
<h2>What are the prerequisites?:</h2>
 <textarea rows="5" cols="5" name="tarea2"  ></textarea>
 
  <br>
<h2>Skills acquired in this course<span>*</span>:</h2>
<textarea rows="5" cols="5" name="tarea3" required></textarea>
 <br />
  <br />
   <br>
 <input type="hidden" name="type" value="add">
 <input type="submit" value="Add Course">
 
 
 


  </form>
 
		
 </body>
 </html>
 
