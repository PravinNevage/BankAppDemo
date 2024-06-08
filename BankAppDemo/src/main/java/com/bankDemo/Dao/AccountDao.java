package com.bankDemo.Dao;

import com.bankDemo.models.Account;

public interface AccountDao {
	
	
	Account getAccountById(int accountId);
	void addAccount(Account account);
	void updateAccount(Account account);
	void deleteAccount(int accountId);
}
