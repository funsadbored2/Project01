package com.javaex.ex01;

public class Person {

	private String name;
	private String hp;
	private String company;
	private int num;

	public Person() {
	}

	public Person(int num) {

		this.num = num;
	}

	public Person(String name, String hp, String company, int num) {

		this.name = name;
		this.hp = hp;
		this.company = company;
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

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

		System.out.println(num + ". " + name + " " + hp + " " + company);

	}


	public String getInfo() {
		String a = ",";
		return name + a + hp + a + company;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", hp=" + hp + ", company=" + company + ", num=" + num + "]";
	}

}
