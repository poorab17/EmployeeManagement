package com.sts.um.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.sts.um.bean.UserBean;
import com.sts.um.dao.UserDao;
import com.sts.um.bean.UserDataUtils;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private UserDao dao ;
       
	public void init(ServletConfig config) throws ServletException {
		 dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
try {
		switch(action) 
		{
		case "/new":
			showNewForm(request,response);
			break;
		
		case "/insert":
			insertUser(request, response);
			break;
		
		case "/comment":
			addComment(request, response);
			break;
			
			
		case "/delete":
			deleteUser(request, response);
			break;
			
		case "/edit":
			showEditForm(request, response);
			break;
					
		    default :
		    	listUser(request, response);
			break;
		} 
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
	private void listUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		    UserBean existingUser;
			List<UserBean> listUser = dao.selectAll();
			request.setAttribute("listUser", listUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			dispatcher.forward(request, response);		
	}
	
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);			
		}

		private void insertUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
		{
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("pass");
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
			
			
			UserBean newUser = new UserBean(name, password, email, mobile, education, age, gender, hobby, detail, comment,file);
			dao.insertUser(newUser);
			response.sendRedirect("list");			
		}
		
		private void addComment(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
		{
             String comment = request.getParameter("comment");
             int  userId =Integer.parseInt(request.getParameter("id")) ;
			UserBean newUser = new UserBean(userId, comment);
			 //newUser.setComment(comment);
			dao.addcomment(newUser);
			response.sendRedirect("list.jsp");
		}
		
		private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
		{
			try {
				int  id =Integer.parseInt(request.getParameter("id")) ;
				
				dao.DeleteUser(id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			response.sendRedirect("list");				
		}
		
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
		{	
			//UserBean existingUser;
			try {
				int  id =Integer.parseInt(request.getParameter("id")) ;
				UserBean existingUser = dao.selectUser(id);
				request.setAttribute("user", existingUser);
				// Set a flag to indicate that it's an edit form
		        request.setAttribute("editMode", true);
		        request.setAttribute("userId", id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
				dispatcher.forward(request, response);
				 
				
			} catch (Exception e) {
				e.printStackTrace();
			}				
		}
		

		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		addComment(request, response);
	}

}
