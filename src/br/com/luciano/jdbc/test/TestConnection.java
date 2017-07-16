package br.com.luciano.jdbc.test;

import java.sql.SQLException;

import br.com.luciano.jdbc.Database;

public class TestConnection {

	public static void main(String[] args) {

		Database database = new Database();
		
		try {
			database.getPoolConnection();
			System.out.println("Connected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
