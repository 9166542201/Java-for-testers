package ru.fw;

public class User {

	private String login;
	private String email;
	private String password;

	public User setLogin(String login) {
		this.login = login;
		return this;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getName() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
