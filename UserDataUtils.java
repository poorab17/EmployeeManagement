package com.sts.um.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sts.um.bean.UserBean;
import com.sts.um.dao.*;

import jakarta.servlet.http.HttpServletRequest;

public class UserDataUtils {
	

	public static UserBean getExistingUserData(HttpServletRequest request) {
	    String idParam = request.getParameter("id");
	    int id = 0; 
	    
	    if (idParam != null && !idParam.isEmpty()) {
	        id = Integer.parseInt(idParam);
	    }
	    else {
	        return null; 
	    }
	    
	    UserBean existingUser = null;
	    	
	    
	    try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_projects","root","root");
			  String sql = "SELECT * FROM user WHERE id = ?";
		        PreparedStatement statement = con.prepareStatement(sql);
		        statement.setInt(1, id);
		        ResultSet resultSet = statement.executeQuery();
		        if (resultSet.next()) {
		        	existingUser= new UserBean();
		        	
		            existingUser.setId(resultSet.getInt("id"));
		            existingUser.setName(resultSet.getString("name"));
		            existingUser.setEmail(resultSet.getString("email"));
		            existingUser.setPassword(resultSet.getString("password"));
		            existingUser.setMobile(resultSet.getString("mobile"));
		            existingUser.setEducation(resultSet.getString("education"));
		            existingUser.setAge(resultSet.getString("age"));
		            existingUser.setGender(resultSet.getString("gender"));
		            existingUser.setHobby(resultSet.getString("hobby"));
		            existingUser.setDetail(resultSet.getString("detail"));
		            existingUser.setComment(resultSet.getString("comment"));
		            existingUser.setComment(resultSet.getString("file"));
		        }
		        else {
		            
		            existingUser = null;
		        }
		        resultSet.close();
		        statement.close();
		        con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	 
	    
	    return existingUser;
	}
	
	


}
