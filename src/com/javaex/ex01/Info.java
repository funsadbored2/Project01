package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

public class Info {

	private ArrayList<Person> list;

	//생성자에 Reader넣어줘서 바로 생성과 함께 메모에 있는 데이터 읽어오게 한다. 후에 바로 Person형 인스턴스로 바꾸고 ArrayList에 넣어준다.
	public Info() throws IOException {

		Reader reader = new FileReader("phoneDB.txt");
		BufferedReader breader = new BufferedReader(reader);
		list = new ArrayList<Person>();
		int num = 1;

		while (true) {

			String line = breader.readLine();

			if (line == null) {
				break;
			}

			String[] info = line.split(",");
			Person person = new Person();
			person.setName(info[0]);
			person.setHp(info[1]);
			person.setCompany(info[2]);
			person.setNum(num++);

			list.add(person);

		}

		reader.close();
	}

	//메인에서 리스트를 선택했을 때 작동하도록 만들어준다. 
	public void listShow() throws IOException {

		for (Person p : list) {

			p.showInfo();
		}

	}
	//메인에서 추가를 선택했을 때 작동하도록 만들어준다. Person 클래스에 getInfo메소드로 메모에 입력시켜준다.
	public void add(Person p) throws IOException {

		Writer writer = new FileWriter("phoneDB.txt");
		BufferedWriter bwriter = new BufferedWriter(writer);

		for (Person e : this.list) {

			bwriter.write(e.getInfo());//기존 데이터들을 읽어와 입력해준다.

			bwriter.newLine();//안하면 엔터 없이 그냥 입력되기 때문에 나중에 읽어올 때 오류가 새길 수 있다.
		}

		bwriter.write(p.getInfo());//마지막으로 새데이터를 입력해준다.
		list.add(p);//데이터를 전역 어레이 리스트 안에 넣어준다.

		bwriter.close();
	}

	//메인에서 삭제를 선택했을 때 작동하도록 만들어준다. 삭제할 데이터 번호를 입력받아 'num'안에 넣어 가져온다.
	public void delete(int num) throws IOException {

		list.remove(--num);//리스트는 배열처럼 0부터 시작하기때문에 메인에서 삭제할 번호로 가져온 num을 하나 뻬고 해당 p형 데이터를 삭제해준다. 
		save();//삭제  한 상로 저장하기 위해 따로 만들어둔 클래스 내의 save() 메소드로 간다.

	}

	//찾기를 선택했을 때 작동하도록 만들어준다. Person 클래스의 getName을 이용해 contains로 입력받은 문자가 포함된 이름을 찾아준다.
	public void search(String search) {

		for (Person e : list) {
			if (e.getName().contains(search)) {
				e.showInfo();
			}

		}

	}
	
	//수정을 선택했을 때 작동하도록 만들어준다. 먼저 해당 데이터를 삭제하기 위해 클래스내의 delete를 이용하고, save메소드도 이용한다.
	public void revise(int num, Person p) throws IOException {

		delete(num);//받아온 num을 delete에 넣어준다.
		list.add(--num, p);//0으로 시작하는 리스트 번호에 따라 num에 1을 빼고 받아온 새로운 p데이터를 넣어준다.
		save();//또 save를 이용해 다시 저장해준다.

	}

	
	private void save() throws IOException {

		Writer writer = new FileWriter("phoneDB.txt");
		BufferedWriter bwriter = new BufferedWriter(writer);

		for (Person e : this.list) {

			bwriter.write(e.getInfo());

			bwriter.newLine();
		}

		bwriter.close();
	}
}
