package com.sts.um.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sts.um.bean.UserBean;



public class UserDao 
{
	public UserDao() {
		
	}
	
	
	
	protected Connection getConnection() {
		Connection con =null;
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_projects","root","root");	
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return con;

}
	
	public void insertUser(UserBean user) 
	{
		
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into user_projects.user(name,email,password,mobile,education,age,gender,hobby,detail,comment,file) values(?,?,?,?,?,?,?,?,?,?,?) ");
			
			  setStatementParameters(pstmt, user.getName(), user.getEmail(), user.getPassword(), user.getMobile(),
	                    user.getEducation(), user.getAge(), user.getGender(), user.getHobby(), user.getDetail(), user.getComment(),user.getFile());
					
			System.out.println(pstmt);
			pstmt.executeUpdate();
				
	      	} catch (Exception e) {
	     	e.printStackTrace();
	     	}
		 
	       }
	
	
	public void addcomment(UserBean user) 
	{
		
		try {
			Connection con = getConnection();
			 String sql = "update user set comment=? where id =?";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, user.getComment());
	            pstmt.setInt(2, user.getId());
	            pstmt.executeUpdate();
	           
	            pstmt.close();
	            con.close();
	            
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	
	
	public UserBean selectUser(int id) {
		UserBean user = null;
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select id,name,email,mobile,age,comment from user where id=?");
			pstmt.setInt(1,id);
			System.out.println(pstmt);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("mobile");
				String age = rs.getString("age");
				String comment = rs.getString("comment");
				user = new UserBean(name, email, address, age, comment);
			}
				
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
		
		return user;
		
		
	}
	
	public List<UserBean> selectAll(){
		
		List<UserBean> users = new ArrayList<UserBean>();
		
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from user_projects.user");
			System.out.println(pstmt);
			//pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String age = rs.getString("age");
				String comment = rs.getString("comment");
				users.add(new UserBean(id, name, email, mobile, age, comment));
				
			}
				
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
		
		
		return users;
		
	}
	
	 private void setStatementParameters(PreparedStatement pstmt, String... values) throws SQLException {
	        for (int i = 0; i < values.length; i++) {
	            pstmt.setString(i + 1, values[i]);
	        }
	    }
	
	public boolean DeleteUser(int id) 
	{
		boolean rowdelete = false;
		
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from user where id=?");
			{
			
			pstmt.setInt(1,id);
			System.out.println(pstmt);
			pstmt.executeUpdate();
			rowdelete =pstmt.executeUpdate()>0;
		}
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
		return rowdelete;
	
	
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	
}

