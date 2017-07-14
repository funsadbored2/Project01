package com.javaex.ex01;

import java.io.IOException;
import java.util.Scanner;

public class PhoneBookApp {

	public static void main(String[] args) throws IOException {
		boolean i = true;
		Scanner sc = new Scanner(System.in);

		System.out.println("******************************");
		System.out.println("*	      전화번호 관리	    *");
		System.out.println("******************************");

		while (i) {

			System.out.println("\n1.리스트  2.등록  3.삭제  4.검색  5.수정 6.종료");
			System.out.println("-------------------------------");
			System.out.print(">메뉴번호:");
			Info info = new Info();
			String menu_num = sc.nextLine();

			switch (menu_num) {
			case "1": {

				System.out.println("<1.리스트>");
				info.listShow();

				continue;

			}
			case "2": {

				Person p = new Person();

				System.out.println("<2.추가>");
				System.out.print("이름:");
				p.setName(sc.nextLine());
				System.out.print("휴대폰 번호:");
				p.setHp(sc.nextLine());
				System.out.print("회사전화번호:");
				p.setCompany(sc.nextLine());

				info.add(p);

				continue;

			}
			case "3": {

				System.out.println("<3.삭제>");
				System.out.print("번호 입력:");
				int delNum = sc.nextInt();

				info.delete(delNum);
				continue;
			}
			case "4": {

				System.out.println("<4.찾기>");
				System.out.print("글자:");
				String a = sc.nextLine();
				info.search(a);

				continue;
			}
			case "5": {

				Person p = new Person();

				System.out.println("<5.수정>");
				System.out.println("수정할 프로필 번호를 입력해주세요");
				System.out.print("번호:");
				int num = sc.nextInt();
				
				System.out.println("어떻게 수정 하실건가요?");
				System.out.print("이름:");
				p.setName(sc.nextLine());
				System.out.println();
				System.out.print("휴대전화 번호:");
				p.setHp(sc.nextLine());
				p.setCompany(sc.nextLine());
				
				info.revise(num, p);
				
				continue;

			}
			case "6": {
				System.out.println("종료합니다.");
				i = false;
				continue;
			}
			default: {
				System.out.println("다시 입력해주세요");
			}
			}
		}

		sc.close();
	}

}
