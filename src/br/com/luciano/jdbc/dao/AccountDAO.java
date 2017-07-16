package br.com.luciano.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.luciano.jdbc.model.Account;

public class AccountDAO {

	private Connection con;

	public AccountDAO(Connection con) {
		this.con = con;
	}

	public void insertAccount(Account account) throws SQLException {
		String sql = "insert into account(user,password) values(?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, account.getUser());
			stmt.setString(2, account.getPassword());
			boolean result = stmt.execute();
			System.out.println("Insert: " + result);
		}
	}

}
