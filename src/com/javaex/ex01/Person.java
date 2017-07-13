package com.javaex.ex01;

public class Person {

	private String name;
	private String hp;
	private String company;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void showInfo() {

		System.out.println(" " + name + " " + hp + " " + company);

	}
	
	public String saveInfo() {
		String comma = ",";
		return name + comma + hp + comma + company; 
	}

}
