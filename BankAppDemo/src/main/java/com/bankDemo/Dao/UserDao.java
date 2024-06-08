package com.bankDemo.Dao;

import com.bankDemo.models.User;

public interface UserDao {
	
	
	User getUserByUsername(String username);
	void addUser(User user);
	void updateUser(User user); 
	void deleteUser(int userId);

}
