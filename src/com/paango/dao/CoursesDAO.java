package com.paango.dao;
  
 
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.Connection;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sun.corba.se.pept.transport.*;
import com.sun.corba.se.pept.transport.*;
@WebServlet("/CoursesDAO")
public class CoursesDAO
{
	 

	public 	String courseDescription="";
	public String courseName="";
	public String level="";
	public String prerequisites="";
	public String skillsAcquired="";
	public String whoShouldDoThisCourse="";
	public String id;
	 
	  
	public String getId() {
		return id;
		} 
	public void setId(String id) {
		this.id = id;
		}
	 
public String getCourseDescription() {
return courseDescription;
} 

public void setCourseDescription(String courseDescription) {
this.courseDescription = courseDescription;
}
public String getCourseName() {
return courseName;
}
public void setCourseName(String courseName) {
this.courseName = courseName;
} 
public String getLevel() {
return level;
} 
public void setLevel(String level) {
this.level = level;
} 
public String getPrerequisites() {
return prerequisites;
} 
public void setPrerequisites(String prerequisites) {
this.prerequisites = prerequisites;
} 
public String getSkillsAcquired() {
return skillsAcquired;
} 
public void setSkillsAcquired(String skillsAcquired) {
this.skillsAcquired = skillsAcquired;
} 
public String getWhoShouldDoThisCourse() {
return whoShouldDoThisCourse;
} 

public void setWhoShouldDoThisCourse(String whoShouldDoThisCourse) {
this.whoShouldDoThisCourse = whoShouldDoThisCourse;
}



 
	public void insert(String url) throws MalformedURLException, IOException,
	ProtocolException {
		 
		 final String user = "root";
		 final String psword = "123";
				 
	Connection c=null; 
	PreparedStatement statement=null;
	 try {
		 
		 Class.forName("com.mysql.jdbc.Driver");
		  int u=0;
	     c=DriverManager.getConnection(url,user,psword);
	     
		  String q="INSERT INTO courses VALUES( ?,?,?,?,?,?,?)";
		  statement = c.prepareStatement(q);
		    
		   statement.setString(1, id);
		   statement.setString(2, courseName);
		   statement.setString(3, courseDescription);
		   statement.setString(4, level);
		   statement.setString(5, whoShouldDoThisCourse);
		   statement.setString(6, prerequisites);
		   statement.setString(7, skillsAcquired);
		  
		   int row = statement.executeUpdate();
		  
		  if (row > 0) 
		 {
			 System.out.println("sucessfully added");
		 }
	 }
	 catch(Exception e)
	 {
		 System.out.println(" unable to connect");
		
	 }
	 finally
	 {
		 try {
			statement.close();
		
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	 
			e.printStackTrace();
		}
	 }
	  
	}
	
	
	
	public void upload(String url, Part filePart) throws MalformedURLException, IOException,
	ProtocolException {
		 InputStream inputStream = null; // input stream of the upload file
         
	        // obtains the upload file part in this multipart request
	       
	        if (filePart != null) {
	        	
	        	inputStream = filePart.getInputStream();
	        }
		 final String user = "root";
		 final String psword = "123";
				 
	Connection c=null; 
	PreparedStatement statement=null;
	 try {
		 
		 
		 Class.forName("com.mysql.jdbc.Driver");
		 
		  c=DriverManager.getConnection(url,user,psword);
 
	   	 
		  String q="INSERT INTO files VALUES(?, ?)";
		  statement = c.prepareStatement(q);
		  statement.setString(1, id);
		  if (inputStream != null) {
              // fetches input stream of the upload file for the blob column
              statement.setBlob(2, inputStream);
          }
		 
		  int row = statement.executeUpdate();
		 
          if (row > 0) {
        	  System.out.println("File uploaded and saved into database");
          }
		  
		  
	 }
	 catch(Exception e)
	 {
		 System.out.println(" unable to connect");
		
	 }
	 finally
	 {
		 try {
			statement.close();
		
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	 
			e.printStackTrace();
		}
	 }
	  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//private final static String USER_AGENT = "Mozilla/5.0";
	 
	
	
	public void update(String url) throws MalformedURLException, IOException,
	ProtocolException { 
		

		 final String user = "root";
		 final String psword = "123";
				 
	Connection c=null; 
	Statement p = null;
	 try {
		 Class.forName("com.mysql.jdbc.Driver");
		
	   
	  c=DriverManager.getConnection(url,user,psword);
	
	 		 p=c.createStatement();
	 		 
			String q="UPDATE courses SET course_name = '"+courseName+"',course_description ='"+courseDescription+"' ,level='"+level+"',who_should_do_this_course='"+whoShouldDoThisCourse+"',prerequisites='"+prerequisites+"',skills_aquired='"+skillsAcquired+"' WHERE id='" + id+"'" ;
			 
		
							 
			 p.execute(q);
			
			
		
	 }
	 catch(Exception e)
	 {
		 System.out.println(" unable to connect Database "+e);
		
	 }
	 finally
	 {
		 try {
			p.close();
		
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			  
			e.printStackTrace();
		}
	 }
	}


	
	
	
	
	
	
	public  void getAllCourses() throws Exception {
		final String user = "root";
		 final String psword = "123";
		Connection c=null; 
		Statement p = null;
	 	
	 	try {
		
			 
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/paango?autoReconnect=true";
			 
		  int u=0;
		   
		  c=DriverManager.getConnection(url,user,psword);
			 p=c.createStatement();
			 String s="select * from courses";
			 ResultSet rs=p.executeQuery(s);
			 
			 
			 while(rs.next())
			 {
				 System.out.println("id   "+rs.getString("id")+"Cname "+rs.getString("course_name"));//so on
			 }
		 
		}  catch(Exception e)
		 {
			 System.out.println(" unable to connect");
			
		 }
		 finally
		 {
			 try {
				p.close();
			
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				 System.out.println(" unable catch "+e);
				e.printStackTrace();
			}
		 }
		 
	 
	  
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void getById(String id) throws Exception {
		final String user = "root";
		 final String psword = "123";
		Connection c=null; 
		Statement p = null;
		 String send="";
	 	try {
		
			 
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/paango?autoReconnect=true";
			 
		     int u=0;
		   
		     c=DriverManager.getConnection(url,user,psword);
			 p=c.createStatement();
			 
			 String s="select * from courses where id="+id;
			
			 ResultSet rs=p.executeQuery(s);
			
			 while(rs.next())
			 {
				
					 
				    setId(rs.getString("id"));
				    setCourseDescription(rs.getString("course_description"));
				    setCourseName(rs.getString("course_name"));
				    setLevel(rs.getString("level"));
				    setPrerequisites(rs.getString("prerequisites"));
				    setSkillsAcquired(rs.getString("skills_aquired"));
				    setWhoShouldDoThisCourse(rs.getString("who_should_do_this_course"));
			 }
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 }
			 catch(Exception e)
			 {
				 System.out.println(" unable to connect");
				
			 }
			 finally
			 {
				 try {
					p.close();
				
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					 System.out.println(" unable catch "+e);
					e.printStackTrace();
				}
			 }
	 	
	 	
	 	
	}

	
	
	
	
	
	
	public void delete() throws MalformedURLException, IOException,
	ProtocolException {
		
		
		 
		 final String user = "root";
		 final String psword = "123";
				 
	Connection c=null; 
	Statement p = null;
	 try {
		 Class.forName("com.mysql.jdbc.Driver");
		
	   
	  c=DriverManager.getConnection( "jdbc:mysql://localhost:3306/paango?autoReconnect=true",user,psword);
	 
	 		 p=c.createStatement();
	 		// String q="UPDATE courses "+ "SET "+"course_name ='aaaaaaa'  WHERE id=1";
			//String q="DELETE FROM courses "+ "WHERE id='+id+'" ;
	 		String q="DELETE FROM files  WHERE id='" + id+"'" ; 
			// p.executeUpdate(q);
			 System.out.println("Status of delete from files "+p.executeUpdate(q));
			 
	 		 q="DELETE FROM courses  WHERE id='" + id+"'" ;
			 
			 		 
			// p.executeUpdate(q);
			 System.out.println("Status of delete from courses "+p.executeUpdate(q));
			   
			
	 }
	 catch(Exception e)
	 {
		 System.out.println(" unable to connect Database "+e);
		
	 }
	 finally
	 {
		 try {
			p.close();
		
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			  
			e.printStackTrace();
		}
	 }
	
 
} }
	
