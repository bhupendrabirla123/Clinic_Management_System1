package com.cms.model;

public class Receptionist_Details {

	private int id;

	private String name;

	private String password;
	private String username;

	public Receptionist_Details() {

	}

	public Receptionist_Details(int id, String name, String password, String username) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
