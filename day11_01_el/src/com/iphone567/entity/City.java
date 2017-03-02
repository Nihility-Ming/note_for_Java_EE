package com.iphone567.entity;

public class City {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City(String name) {
		this.name = name;
	}

	public City() {
	}

	@Override
	public String toString() {
		return "City [name=" + name + "]";
	}	
	
}
