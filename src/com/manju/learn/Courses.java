package com.manju.learn;
 

 
import com.paango.dao.CoursesDAO;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/** 
 * Servlet implementation class Courses
 */
@WebServlet("/Courses")
@MultipartConfig(maxFileSize = 21665)

public class Courses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpServletResponse response;
	/**
	 * Default constructor.
	 */

	public Courses() {
		
 // TODO Auto-generated constructor stub
	}
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String s=(String)request.getParameter("type1");
	System.out.println("type "+s);
		 try
		 {
	 switch(s)
	 {
	 case "A" :
		  
		
		 Part filePart = request.getPart("photo");
		CoursesDAO course=new CoursesDAO();
		 
		//PrintWriter pw = response.getWriter();
		course.setId(request.getParameter("cid"));
		course.setCourseDescription(request.getParameter("cdesc"));
		course.setCourseName(request.getParameter("cname"));
		course.setLevel(request.getParameter("level"));
		course.setPrerequisites(request.getParameter("tarea2"));
		course.setSkillsAcquired(request.getParameter("tarea3"));
		course.setWhoShouldDoThisCourse(request.getParameter("tarea1"));
		
		course.insert("jdbc:mysql://localhost:3306/paango?autoReconnect=true");
		course.upload("jdbc:mysql://localhost:3306/paango?autoReconnect=true", filePart);

		
		
		
		
		
		
		
		
		
		
		
	
		
	 
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	 
		break;
	 case "E" :
		 
			doPut(request, response);
		
	break;
	 case "D" :
		 
			 
			doDelete(request, response); 
	 }
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println("SWITCH    "+e);
		 }
	}
	
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		InputStream inputStream = null; // input stream of the upload file
        
        // obtains the upload file part in this multipart request
       
      
	 final String user = "root";
	 final String psword = "123";
			 
Connection c=null; 
Statement p = null;

	 
	 
	 try {
		Class.forName("com.mysql.jdbc.Driver");
		 System.out.println("for namr");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 
	  try {
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/paango?autoReconnect=true",user,psword);
		 System.out.println("DM");
		 } catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
   	 try {
		p=c.createStatement();
		 System.out.println("CS");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
			
			
			
			
		String id=	"0";
		id=request.getParameter("cid");
		
		if(id==null)
		{
			id=request.getParameter("id");
		}
		 
   	String s1="select * from files where id="+id;
	 
	 
		try {
			ResultSet rs=p.executeQuery(s1);
			 System.out.println("EQ");
			if (rs.next()) {
			        // gets file name and file blob data
				 System.out.println("EQRS");
			        Blob blob = rs.getBlob("file");
			         inputStream = blob.getBinaryStream();
			        int fileLength = inputStream.available();
			         
			        System.out.println("fileLength = " + fileLength);

			         

			        // sets MIME type for the file download
			                     
			        String mimeType = "text file";
			        // set content properties and header attributes for the response
			        response.setContentType(mimeType);
			        response.setContentLength(fileLength);
			        String headerKey = "Content-Disposition";
			        String headerValue = String.format("attachment; filename=text file");
			        response.setHeader(headerKey, headerValue);

			        
			     
			        // writes the file to the client
			        OutputStream outStream = response.getOutputStream();
			        final int BUFFER_SIZE = 4096;
			        byte[] buffer = new byte[BUFFER_SIZE];
			        int bytesRead = -1;
			         
			        while ((bytesRead = inputStream.read(buffer)) != -1) {
			            outStream.write(buffer, 0, bytesRead);
			        }
			         
			        inputStream.close();
			        outStream.close();             
			    } else {
			        // no file found
			        response.getWriter().print("File not found for the id: " + request.getParameter("cid"));  
			    }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			 System.out.println("EQ     "+e1);
			e1.printStackTrace();
		}
				
			 
				 try {
					p.close();
				
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
			 
					e.printStackTrace();
				}
			 
			
		
 
 
	
	
	
	
	
	
	
	RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
	dispatcher.forward(request, response);
 
		
	
	
	}
		
	
		
		
	/** 
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
		
 
	 
		
		 
		 
		CoursesDAO course=new CoursesDAO();
		
		course.setId(request.getParameter("cid"));
		course.setCourseDescription(request.getParameter("cdesc"));
		course.setCourseName(request.getParameter("cname"));
		course.setLevel(request.getParameter("level"));
		course.setPrerequisites(request.getParameter("tarea2"));
		course.setSkillsAcquired(request.getParameter("tarea3"));
		course.setWhoShouldDoThisCourse(request.getParameter("tarea1"));
	 
		course.update("jdbc:mysql://localhost:3306/paango?autoReconnect=true");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}





	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		CoursesDAO course=new CoursesDAO();
		String s=request.getParameter("hidden");
		
		course.setId(s);
		 
		
		course.delete();
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}
