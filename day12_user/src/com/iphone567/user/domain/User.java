package com.iphone567.user.domain;

public class User {
	private int id;
	private String username;
	private String password;
	private int age;
	private String email;
	private String gender;
	private String description;
	private boolean is_delete;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isIs_delete() {
		return is_delete;
	}
	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}
	public User(int id, String username, String password, int age, String email, String gender, String description, boolean is_delete) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.description = description;
		this.is_delete = is_delete;
	}
	public User() {
		super();
		
	}
	
	
}
