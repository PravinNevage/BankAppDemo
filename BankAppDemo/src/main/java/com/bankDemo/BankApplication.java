package com.bankDemo;

import java.sql.Connection;

import com.bankDemo.connection.DatabaseConnection;

public class BankApplication {

	public static void main(String[] args) {
		System.out.println("This is main class");
		Connection con = DatabaseConnection.connection();

	}

}
