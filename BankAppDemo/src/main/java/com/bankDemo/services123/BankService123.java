package com.bankDemo.services123;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankDemo.Dao.AccountDao;
import com.bankDemo.Dao.UserDao;
import com.bankDemo.models.Account;
import com.bankDemo.models.User;

import lombok.Data;
import lombok.NoArgsConstructor;



@Service
public class BankService123 {
    @Autowired
	private UserDao Userdao;
	@Autowired
	private AccountDao Accountdao;
	
	public User login(String username , String password)
	{
		return null;
		
	
	}
	
	
	public Account getAccount(int accountId) 
	{
		return null;
	
		
		
	}
	
	
	public void deposit(int accountId)
	{
		
		
	}
	
	
	public void withdraw(int accountId, double balance)
	{
		
		
	}
	
}
