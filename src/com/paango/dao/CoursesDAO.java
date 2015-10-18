package com.paango.dao;
 
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
  
public class CoursesDAO
{
	 

	public 	String courseDescription="";
	public String courseName="";
	public String level="";
	public String prerequisites="";
	public String skillsAcquired="";
	public String whoShouldDoThisCourse="";
	public String id="";
	public String rev="";
	  
	public String getId() {
		return id;
		} 
	public void setId(String id) {
		this.id = id;
		}
	public String getRev() {
		return rev;
		} 
	public void setRev(String rev) {
		this.rev = rev;
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



private String packageAsJSON(String name, String value){
	//Check if the value field has a double quote in it
	//Replace the double quotes with single quotes to avoid
	//Wrong formatting of the json string
	String value1 = value.replace("\"", "'");
	return "\"" + name + "\":\"" + value1 + "\"";
	}

	public void insert(String url) throws MalformedURLException, IOException,
	ProtocolException {
	//create JSON
	String json = "{" + packageAsJSON("courseName", courseName) + ", "
	+ packageAsJSON("courseDescription", courseDescription) + ", "
	+ packageAsJSON("level", level) + ", "
	+ packageAsJSON("prerequisites", prerequisites) + ", "
	+ packageAsJSON("skillsAcquired", skillsAcquired) + ", "
	+ packageAsJSON("whoShouldDoThisCourse", whoShouldDoThisCourse)
	+ "}" ; 
	URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	//add request header
	con.setRequestMethod("POST");
	con.setRequestProperty("Content-Type", "application/json");
	 
	con.setDoOutput(true);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	wr.writeBytes(json);
	 
	wr.flush();
	wr.close();
	int responseCode = con.getResponseCode();
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + json);
	System.out.println("Response Code : " + responseCode);
	}
	
	//private final static String USER_AGENT = "Mozilla/5.0";
	 
	
	
	public void update(String url) throws MalformedURLException, IOException,
	ProtocolException { 
		
		 
		String json = "{"+ packageAsJSON("_id",id ) + ", "+ packageAsJSON("_rev",rev ) + ", " + packageAsJSON("courseName",courseName ) + ", "
				+ packageAsJSON("courseDescription", courseDescription) + ", "
				+ packageAsJSON("level", level) + ", "
				+ packageAsJSON("prerequisites", prerequisites) + ", "
				+ packageAsJSON("skillsAcquired", skillsAcquired) + ", "
				+ packageAsJSON("whoShouldDoThisCourse", whoShouldDoThisCourse)
				+ "}" ; 
				URL obj = new URL(url);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				//add request header
				con.setRequestMethod("POST");// if i set request method into "PUT" , Precondition Failed will occur  here what should i do..
				con.setRequestProperty("Content-Type", "application/json");
		 
				
				con.setDoOutput(true); 
				DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				wr.writeBytes(json);
				 
				wr.flush();
				wr.close();
				int responseCode = con.getResponseCode();
				String status=con.getResponseMessage();
				System.out.println("\nSending 'POST' request to URL : " + url);
				System.out.println("\nStatus : " +status);
				System.out.println("Post parameters : " + json);
				System.out.println("Response Code : " + responseCode);
		
			}
	
	public  String getAllCourses() throws Exception {
		
	 	URL obj = new URL("http://localhost:5984/courses/_design/lms/_view/mycourses");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET"); 
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoInput(true);
		BufferedReader in = new BufferedReader(new
		InputStreamReader(con.getInputStream()));
		String inputLine;
		String send=" " ;
		while ((inputLine = in.readLine()) != null) {
			 send+=inputLine;
		} 
		 
		return send;
	  
	} 
	
	public String getById(String id) throws Exception {
		URL obj = new URL("http://localhost:5984/courses/"+id);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoInput(true);
		BufferedReader in = new BufferedReader(new
		InputStreamReader(con.getInputStream()));
		String inputLine;
		String send=" " ;
		while ((inputLine = in.readLine()) != null) {
			 send+=inputLine;
		} 
		 return send;
	}
	
	
	
	public void delete(String url) throws MalformedURLException, IOException,
	ProtocolException {
		
		
		String json = "{  }" ;  
				URL obj = new URL(url);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				//add request header
				con.setRequestMethod("DELETE");
			 
				 
				con.setRequestProperty("Content-Type", "application/json");
		 
				
				con.setDoOutput(true); 
				DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				 wr.writeBytes(json);
				 				 
				wr.flush();
				wr.close();
				int responseCode = con.getResponseCode();
				String status=con.getResponseMessage();
				System.out.println("\nSending 'POST' request to URL : " + url);
				System.out.println("\nStatus : " +status);
				System.out.println("Post parameters : " + json);
				System.out.println("Response Code : " + responseCode);
		
	}
	
	
 
} 
	
