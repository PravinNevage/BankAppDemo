package com.bankDemo.Dao.Impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.bankDemo.Dao.UserDao;
import com.bankDemo.connection.DatabaseConnection;
import com.bankDemo.models.User;

@Component
public class UserDaoImpl implements UserDao{

	
	 Connection con = DatabaseConnection.connection();	

	@Override
	public User getUserByUsername(String username) {
	
	try {
    String sql= "Select * from user where username = ? ";
    PreparedStatement pstm = con.prepareStatement(sql);
    pstm.setString(1, username);
    ResultSet rs = pstm.executeQuery();    
    if(rs.next())
    {
    	
        int id = rs.getInt("id");
        String usernameDB = rs.getString("username");
        String password = rs.getString("password");
        String role = rs.getString("role");
        
        return new User(id, usernameDB, password, role);
    }
    
    if (rs != null) {
		rs.close();
		rs = null;
	}
	if (pstm != null) {
		pstm.close();
		pstm = null;
	}
    
	} catch (Exception e) {
    e.printStackTrace();
    }	
	return null;
	}

	@Override
	public void addUser(User user) {
		try {
			
			String Sql1 = "INSERT INTO Users (username, password, role) VALUES (?, ?, ?)";
			PreparedStatement pstm = con.prepareStatement(Sql1);
			pstm.setString(1, user.getUsername());
			pstm.setString(1, user.getPassword());
			pstm.setString(1, user.getRole());
			pstm.executeUpdate();
			
			if (pstm != null) {
				pstm.close();
				pstm = null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User user) {
		try {
			
			String Sql2="UPDATE Users SER Username=? , password = ?, role = ? WHERE id = ?" ;
			PreparedStatement pstm = con.prepareStatement(Sql2);
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getRole());
			pstm.setInt(4, user.getUserId());
			pstm.executeUpdate();
			
			if (pstm != null) {
				pstm.close();
				pstm = null;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void deleteUser(int userId) {

    try {
    	 String Sql3 = "DELETE FROM Users WHERE id = ?";
    	 PreparedStatement pstm = con.prepareStatement(Sql3);
    	 pstm.setInt(1,userId);
    	 pstm.executeUpdate();
			
			if (pstm != null) {
				pstm.close();
				pstm = null;
			}
			
	} catch (Exception e) {
		// TODO: handle exception
	}
		
	 finally {
			try {
				if (con != null) 
				{
					con.close();
					con = null;
				}

			} catch (Exception d) {
				d.printStackTrace();
			}
		}
    
	}

}
