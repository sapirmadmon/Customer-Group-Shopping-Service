package com.example.demo.boundaries;

public class User {
	private String email;

	public User() {
		super();
	}

	public User(String email) {
		super();
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserBoundary [email=" + email + "]";
	}

	
	
}
