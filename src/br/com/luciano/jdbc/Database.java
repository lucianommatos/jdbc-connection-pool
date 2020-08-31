package br.com.luciano.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Database {

	private DataSource dataSource;
	
	public Database() {
		MysqlDataSource pool = new MysqlDataSource();
		pool.setUrl("jdbc:mysql://localhost:3306/financas");
		pool.setUser("root");
		pool.setPassword("123456");
		this.dataSource = pool;
	}
	
	public Connection getPoolConnection() throws SQLException {
		return this.dataSource.getConnection();
	}
	
}
