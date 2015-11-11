package com.manju.learn;
 
 
import com.paango.dao.CoursesDAO;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Servlet implementation class Courses
 */
@WebServlet("/Courses")
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
		
		String s=(String)request.getParameter("type");
		 
	//	String x=request.getParameter("hidden");
	 switch(s)
	 {
	 case "A" :
	 
		  
		 
			  
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
	
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
 
		CoursesDAO course=new CoursesDAO();
		PrintWriter pw = response.getWriter();
		try {
			  
	course.getAllCourses();
	 
	 
	
	
				pw.println();	
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		 
		
		
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
