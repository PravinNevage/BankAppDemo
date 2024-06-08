package com.bankDemo.services.Impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankDemo.Dao.AccountDao;
import com.bankDemo.Dao.UserDao;
import com.bankDemo.models.Account;
import com.bankDemo.models.User;
import com.bankDemo.services.BankService;

@Service
public class BankServiceImpl implements BankService{

	
    @Autowired
	private UserDao userDao;
	@Autowired
	private AccountDao accountDao;
	
	
	@Override
	public User login(String username, String password) {
	
		User Username = userDao.getUserByUsername(username);
		return Username;
	}

	@Override
	public Account getAccount(int accountId) {
		Account accountById = accountDao.getAccountById(accountId);
        return accountById;
	}

	@Override
	public void deposit(int accountId , double amount) {
		
		Account account = accountDao.getAccountById(accountId);
		double balanceDp = account.getBalance();
        balanceDp+=amount;
		account.setBalance(balanceDp);
		accountDao.updateAccount(account);
	}

	@Override
	public void withdraw(int accountId, double amount) {
		Account account = accountDao.getAccountById(accountId);
		double balanceAmtWid = account.getBalance();
		if(balanceAmtWid>=amount)
		{
			balanceAmtWid-=amount;	
		}
		else {
			System.out.println("Insufficient balance ");
		}
		account.setBalance(balanceAmtWid);
		accountDao.updateAccount(account);
	}

}
