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
		
		String s=request.getParameter("type");
		
		String x=request.getParameter("hidden");
		if(x!=null)            // OR if(s!="add")
		{
		 
			doPut(request, response);
		}
		else
		{             
		
		CoursesDAO course=new CoursesDAO();
		
		//PrintWriter pw = response.getWriter();

		course.setCourseDescription(request.getParameter("cdesc"));
		course.setCourseName(request.getParameter("cname"));
		course.setLevel(request.getParameter("level"));
		course.setPrerequisites(request.getParameter("tarea2"));
		course.setSkillsAcquired(request.getParameter("tarea3"));
		course.setWhoShouldDoThisCourse(request.getParameter("tarea1"));
		
		course.insert("http://localhost:5984/courses");
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	 
		}
	}
	
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
 
		CoursesDAO course=new CoursesDAO();
		PrintWriter pw = response.getWriter();
		try {
			  
				String s= course.getAllCourses();
		  
				pw.println(s);	
					
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
		course.setCourseDescription(request.getParameter("cdesc"));
		course.setCourseName(request.getParameter("cname"));
		course.setLevel(request.getParameter("level"));
		course.setPrerequisites(request.getParameter("tarea2"));
		course.setSkillsAcquired(request.getParameter("tarea3"));
		course.setWhoShouldDoThisCourse(request.getParameter("tarea1"));
		String s=request.getParameter("hidden");
		String s1=request.getParameter("revision");
	 
		course.setId(s);
		course.setRev(s1);
		
		course.update("http://localhost:5984/courses");
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	 
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
