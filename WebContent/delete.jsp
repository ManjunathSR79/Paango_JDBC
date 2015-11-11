<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="addcourse" method="post" action="Courses">

  
<script type="text/javascript">
alert("If You Want To Delete It.");
 
</script>
 
<input type="hidden" name="hidden" id="hidden" value='<%=request.getParameter("id")%>' />
  <input type="hidden" name="type" value="D">
  
  <input type="submit" value="Delete Course">
 
 </form>
</body>
</html>
