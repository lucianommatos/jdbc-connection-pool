package br.com.luciano.jdbc.test;

import java.sql.SQLException;

import br.com.luciano.jdbc.Database;
import br.com.luciano.jdbc.dao.AccountDAO;
import br.com.luciano.jdbc.model.Account;

public class TestUpdate {

	public static void main(String[] args) {

		Database database = new Database();
		
		try {
			AccountDAO dao = new AccountDAO(database.getPoolConnection());
			Account account = dao.getAccountById(1);
			System.out.println(account.toString());
			
			account.setUser("newUpdateUser@gmail.com");
			dao.updateAccount(account);
			
			account = dao.getAccountById(1);
			System.out.println(account.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
