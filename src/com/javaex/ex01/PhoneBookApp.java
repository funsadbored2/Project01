package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookApp {

	public static void main(String[] args) throws IOException {
		boolean i = true;

		Reader reader = new FileReader("phoneDB.txt");
		BufferedReader breader = new BufferedReader(reader);
		Writer writer = new FileWriter("phoneDB.txt");
		BufferedWriter bwriter = new BufferedWriter(writer);

		Person person = new Person();
		List<Person> list = new ArrayList<Person>();

		Scanner sc = new Scanner(System.in);

		System.out.println("******************************");
		System.out.println("*	      전화번호 관리	    *");
		System.out.println("******************************");

		while (i) {

			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("-------------------------------");
			System.out.print(">메뉴번호:");
			int menu_num = sc.nextInt();
			sc.nextLine();

			switch (menu_num) {
			case 1: {

			}
			case 2: {

				System.out.print(">이름:");
				person.setName(sc.nextLine());
				System.out.print("휴대폰:");
				person.setName(sc.nextLine());
				System.out.print("회사번호:");
				person.setName(sc.nextLine());
				
				while (true) {

					String info = breader.readLine();
					if (info == null) {
						break;
					}
					writer.write(info);
				}

				writer.write(person.saveInfo());

			}
			case 3: {
				String[] info = breader.readLine().split(",");

				person.setName(info[0]);
				person.setHp(info[1]);
				person.setCompany(info[2]);

				list.add(person);
				// outputstream을 통해 읽고 부분만 입력 아마 if문 사용
			}
			case 4: {
				// inputstream을 통해 string 으로 읽어오고 나서 if문써서 찾아오기
			}
			case 5: {
				i = false;
			}
			default: {
				System.out.println("다시 입력해주세요");
			}
			}
		}

		breader.close();
	}

}
