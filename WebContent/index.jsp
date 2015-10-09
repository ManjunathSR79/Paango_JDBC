<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 
</head>
<body >

<form method="post" action="addcourse.jsp">

<input 	type="submit" value="Add Course">
</form>
 
<p id="course"></p>
 
 <script type="text/javascript"  > 
 
 var xhr = new XMLHttpRequest();
 xhr.onreadystatechange = function()
 {
     if (xhr.readyState == 4)
     {
    	 var data = xhr.responseText;
         var  mycourses = JSON.parse(data);
         var inputLine;
         var len=mycourses.rows.length;
         var tmp="";
     	 var i;
     	 var out=""
     	 out+='<table  border="1" style="width:100%"><tr><td><a href="editCourse.jsp?id=http://localhost:5984/courses/_design/lms/_view/mycourses">editCourse</tr><tr><td>courseName</td><td>courseDescription</td><td>level</td><td>prerequisites</td><td>skillsAcquired</td><td>whoShouldDoThisCourse</td></tr>';
         for( i=0;i<len ;i++)
        	{
        	 Temp=mycourses.rows[i].value;
        	 out+='<tr><td>'+Temp.courseName+'</td><td>'+Temp.courseDescription+'</td><td>'+Temp.level+'</td><td>'+Temp.prerequisites+'</td><td>'+Temp.skillsAcquired+'</td><td>'+Temp.whoShouldDoThisCourse+'</td></tr>';
        	}
            out+='</table>';    
            document.getElementById("course").innerHTML = out;
   	 }
 }
 xhr.open('GET', 'Courses', true);
 xhr.send(null);
 </script>
 </body>
 </html>
