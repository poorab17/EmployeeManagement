package com.sts.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;
import com.sts.um.bean.UserBean;


@WebServlet("/register")
@MultipartConfig(fileSizeThreshold = 1024*1024*2,
maxFileSize = 1024*1024*10,
maxRequestSize =1024*1024*50)
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	        
		 String userIdParam = request.getParameter("id");
		  boolean isEditMode = userIdParam != null && !userIdParam.isEmpty();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String act_password = request.getParameter("pass");
		String password = BCrypt.hashpw(act_password, BCrypt.gensalt());
		String reupwd = request.getParameter("re-pass");
		String mobile = request.getParameter("contact");
		String education=request.getParameter("education");
		String age = request.getParameter("age");
		String gender= request.getParameter("gender");
		String[] hobbiesString = request.getParameterValues("hobbies");
	    String hobby = String.join(", ", hobbiesString);
		String detail = request.getParameter("details");
		String comment = request.getParameter("comment");
		String file = request.getParameter("profile-pic");
		
		 Part filePart = request.getPart("profile-pic");
	        String fileName = getFileName(filePart);
	        
	        if (fileName != null && !fileName.isEmpty()) 
	        {
	        	String uploadPath = "C:\\Users\\deepak.gupta\\Desktop\\fromRegister\\" + fileName;
	        	filePart.write(uploadPath);
	        	 try (InputStream inputStream = filePart.getInputStream()) {
	                 Files.copy(inputStream, Path.of(uploadPath), StandardCopyOption.REPLACE_EXISTING);
	             } catch (IOException e) {
	                 e.printStackTrace();
	             }
	        }
		
		RequestDispatcher dispatcher = null;
		Connection con =null;
		
		if (name == null || name.equals("")) 
		{
			request.setAttribute("status","invalidName");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			return;
			
		}
		
		else if (!name.matches("[a-zA-Z][a-zA-Z ]*")) {
		    
		    request.setAttribute("status", "invalidCharacters");
		    dispatcher = request.getRequestDispatcher("registration.jsp");
		    dispatcher.forward(request, response);
		    return;
		} 
		
		else if (name.length() < 2 || name.length() > 50) {
		  
		    request.setAttribute("status", "invalidLength");
		    dispatcher = request.getRequestDispatcher("registration.jsp");
		    dispatcher.forward(request, response);
		    return;
		}
				
		if (password == null || password.equals("")) 
		{
			request.setAttribute("status","invalidUpwd");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			return;
				
		}
		else if (password.length() < 8) {
		    request.setAttribute("status", "invalidPwdLength");
		    dispatcher = request.getRequestDispatcher("registration.jsp");
		    dispatcher.forward(request, response);
		    return;
		}
		
		else if (password.equals(reupwd)) {
			
			request.setAttribute("status","invalidConfirmpwd");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			
		}
		
		if (email == null || email.equals("")) 
		{
			request.setAttribute("status","invalidEmail");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			
		}
		else if (!email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b")) {
		    request.setAttribute("status", "invalidEmailFormat");
		    dispatcher = request.getRequestDispatcher("registration.jsp");
		    dispatcher.forward(request, response);
		    return;
		}
		
		if (mobile == null || mobile.equals("")) 
		{
			request.setAttribute("status","invalidUmobile");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		else if (mobile.length()!=10)
		{
			request.setAttribute("status","invalidUmobilelength");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_projects?useSSL=false","root","root");
		      if (isEditMode) {
		          int userId = Integer.parseInt(userIdParam);
		          PreparedStatement pstmt = con.prepareStatement("UPDATE user_projects.user SET name=?, email=?, password=?, mobile=?, education=?, age=?, gender=?, hobby=?, detail=?, comment=?, file=? WHERE id=?");
		          pstmt.setString(1, name);
		          pstmt.setString(2, email);
		          pstmt.setString(3, password);
		          pstmt.setString(4, mobile);
		          pstmt.setString(5, education);
		          pstmt.setString(6, age);
		          pstmt.setString(7, gender);
		          pstmt.setString(8, hobby);
		          pstmt.setString(9, detail);
		          pstmt.setString(10, comment);
		          pstmt.setString(11, file);
		          pstmt.setInt(12, userId);

		          int rowCount = pstmt.executeUpdate();
		          
		          if (rowCount > 0) {
		              request.setAttribute("status", "success");
		          } else {
		              request.setAttribute("status", "failed");
		          }
		          dispatcher = request.getRequestDispatcher("user-list.jsp");
		          dispatcher.forward(request, response);
		            
		      }
		      
		    else {
			PreparedStatement pstmt = con.prepareStatement("insert into user_projects.user(name,email,password,mobile,education,age,gender,hobby,detail,comment,file) values(?,?,?,?,?,?,?,?,?,?,?) ");
			pstmt.setString(1,name);
			pstmt.setString(2,email);
			pstmt.setString(3,password);
			pstmt.setString(4,mobile);
			pstmt.setString(5,education);
			pstmt.setString(6,age);
			pstmt.setString(7,gender);
			pstmt.setString(8,hobby);
			pstmt.setString(9,detail);
			pstmt.setString(10,comment);
			pstmt.setString(11,file);

			int rowcount = pstmt.executeUpdate();
			//dispatcher = request.getRequestDispatcher("registration.jsp");
			
		if(rowcount>0){
				request.setAttribute("status", "success");	
			}
			
			else {
				request.setAttribute("status", "failed");	
			}
		    dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			
		}} catch (Exception e) {
		e.printStackTrace();
		}
		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	private String getFileName(Part part) {
	    String contentDispositionHeader = part.getHeader("content-disposition");
	    String[] elements = contentDispositionHeader.split(";");
	    for (String element : elements) {
	        if (element.trim().startsWith("filename")) {
	            return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
	
	
}
