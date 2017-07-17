package br.com.luciano.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.luciano.jdbc.model.Account;

public class AccountDAO {

	private Connection con;

	public AccountDAO(Connection con) {
		this.con = con;
	}

	public void createAccount(Account account) throws SQLException {
		String sql = "insert into account(user,password) values(?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, account.getUser());
			stmt.setString(2, account.getPassword());
			stmt.execute();
			System.out.println("Account inserted!");
		}
	}

	public void removeAccountByUser(String user) throws SQLException {
		String sql = "delete from account where user = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user);
			stmt.execute();
			System.out.println("Account removed!");
		}
	}

	public void updateAccount(Account account) throws SQLException {
		String sql = "update account set user = ?, password = ? where id = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, account.getUser());
			stmt.setString(2, account.getPassword());
			stmt.setInt(3, account.getId());
			stmt.execute();
			System.out.println("Account updated!");
		}
	}

	public Account getAccountById(int id) throws SQLException {
		String sql = "select * from account where id = ?";
		Account account = new Account();
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet result = stmt.executeQuery()) {
				while (result.next()) {
					account.setId(result.getInt("id"));
					account.setUser(result.getString("user"));
					account.setPassword(result.getString("password"));
				}
			}
		}
		return account;
	}

	public List<Account> listAccounts() throws SQLException {
		List<Account> list = new ArrayList<>();
		String sql = "select * from account";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			try (ResultSet result = stmt.executeQuery()) {
				while (result.next()) {
					Account account = new Account();
					account.setId(result.getInt("id"));
					account.setUser(result.getString("user"));
					account.setPassword(result.getString("password"));
					list.add(account);
				}
			}
		}
		System.out.println("All selected!");
		return list;
	}

}
