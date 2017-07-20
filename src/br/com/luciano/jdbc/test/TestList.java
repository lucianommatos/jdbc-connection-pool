package br.com.luciano.jdbc.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.luciano.jdbc.Database;
import br.com.luciano.jdbc.dao.AccountDAO;
import br.com.luciano.jdbc.model.Account;

public class TestList {

	public static void main(String[] args) {

		Database database = new Database();
		try {
			AccountDAO dao = new AccountDAO(database.getPoolConnection());
			List<Account> accounts = new ArrayList<Account>();
			accounts = dao.listAccounts();
			for (Account account : accounts) {
				System.out.println(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
