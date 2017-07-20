package br.com.luciano.jdbc.test;

import java.sql.SQLException;

import br.com.luciano.jdbc.Database;
import br.com.luciano.jdbc.dao.AccountDAO;

public class TestRemove {
	public static void main(String[] args) {
		Database database = new Database();
		
		try {
			AccountDAO dao = new AccountDAO(database.getPoolConnection());
			dao.removeAccountByUser("teste@gmail.com");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
