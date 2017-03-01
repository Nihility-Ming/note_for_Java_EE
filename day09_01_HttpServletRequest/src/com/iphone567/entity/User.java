package com.iphone567.entity;

import java.util.Arrays;

public class User {
	private String username;
	private String password;
	private String gender;
	private String[] xq;
	private String city;
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
	public String getGender() {
		return gender;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", gender=" + gender + ", xq="
				+ Arrays.toString(xq) + ", city=" + city + "]";
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getXq() {
		return xq;
	}
	public void setXq(String[] xq) {
		this.xq = xq;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public User(String username, String password, String gender, String[] xq, String city) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.xq = xq;
		this.city = city;
	}
	
	public User(){}
}
