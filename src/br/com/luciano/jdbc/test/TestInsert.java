package br.com.luciano.jdbc.test;

import java.sql.SQLException;

import br.com.luciano.jdbc.Database;
import br.com.luciano.jdbc.dao.AccountDAO;
import br.com.luciano.jdbc.model.Account;

public class TestInsert {

	public static void main(String[] args) {

		Database database = new Database();
		
		Account account = new Account("kkk@gmail.com", "123123");
		
		try {
			AccountDAO dao = new AccountDAO(database.getPoolConnection());
			dao.createAccount(account);
			System.out.println("Inserted!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
