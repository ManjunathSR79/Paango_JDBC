
   function getCourses()
 {
	 
 if(widow.XMLHttpRequest)
	 var xhr= new XMLHttpRequest();
 else
	 xhr= new ActiveXobject("Microsoft.XMLHTTP");
	 xhr.onreadystatechange=receivePlace;
	  
 
	 xhr.open("GET","Courses.java",true);
		 xhr.send(null);
		 
	 
	 

 }
 