package br.com.luciano.jdbc.model;

public class Account {

	private int id;
	private String user;
	private String password;
	
	public Account() {
		super();
	}
	
	public Account(String user, String password) {
		this.user = user;
		this.password = password;
	}
	
	public Account(int id, String user, String password) {
		this.id = id;
		this.user = user;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", password=" + password + "]";
	}
	
	
}
