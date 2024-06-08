package com.bankDemo.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

import com.bankDemo.Dao.AccountDao;
import com.bankDemo.connection.DatabaseConnection;
import com.bankDemo.models.Account;

@Component
public class AccountDaoImpl implements AccountDao{

	 Connection con = DatabaseConnection.connection();	
	
	
	@Override
	public Account getAccountById(int accountId) {
	try {
		String sql = "SELECT * FROM Accounts WHERE id = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, accountId);
		ResultSet rs = pstm.executeQuery();
		if(rs.next())
		{
			rs.getInt("id");
			rs.getInt("userId");
			rs.getBoolean("balance");
			
			return new Account(accountId, accountId, accountId); 
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
		// TODO: handle exception
	}	
		return null;
	}

	@Override
	public void addAccount(Account account) {
		try {
			String query = "INSERT INTO Accounts (user_id, balance) VALUES (?, ?)";
	      	    PreparedStatement pstm = con.prepareStatement(query);
	      		pstm.setInt(1, account.getUserId());
	            pstm.setDouble(2, account.getBalance());
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
	public void updateAccount(Account account) {
		try {
			String query = "UPDATE Accounts SET user_id = ?, balance = ? WHERE id = ?";
	      	    PreparedStatement pstm = con.prepareStatement(query);
	      	    pstm.setInt(1, account.getUserId());
	      	    pstm.setDouble(2, account.getBalance());
	         	pstm.setInt(3, account.getAccountId());
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
	public void deleteAccount(int id) {
		
		try {
			String query ="DELETE FROM Accounts WHERE id = ?";
      	    PreparedStatement pstm = con.prepareStatement(query);
      	    pstm.setInt(1, id);
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
