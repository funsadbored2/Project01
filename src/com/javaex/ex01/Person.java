package com.javaex.ex01;

public class Person {

	private String name;
	private String hp;
	private String company;
	private int num;

	//필드
	public Person() {
	}

	public Person(int num) {

		this.num = num;
	}

	//메소드
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

	//출력용 메소드
	public void showInfo() {

		System.out.println(num + ". " + name + " " + hp + " " + company);
	}

	//다시 데이터에 입력해주기 위해서 포맷에 맞춰 바꿔주기위한 메소드
	public String getInfo() {
		String a = ",";
		return name + a + hp + a + company;
	}

	//테스트용 스트링
	@Override
	public String toString() {
		return "Person [name=" + name + ", hp=" + hp + ", company=" + company + ", num=" + num + "]";
	}

}
