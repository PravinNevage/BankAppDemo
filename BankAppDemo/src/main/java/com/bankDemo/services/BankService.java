package com.bankDemo.services;



import com.bankDemo.models.Account;
import com.bankDemo.models.User;

public interface BankService {
	
	 User login(String username , String password);
	
	 Account getAccount(int accountId) ;
	
	 void deposit(int accountId , double  amount);

	 void withdraw(int accountId, double amount);
}
