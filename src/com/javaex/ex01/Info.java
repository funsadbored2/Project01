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

	/*
	 * private void save() throws IOException {
	 * 
	 * 
	 * }
	 */
	public void listShow() throws IOException {

		for (Person p : list) {

			p.showInfo();
		}

	}

	public void add(Person p) throws IOException {

		Writer writer = new FileWriter("phoneDB.txt");
		BufferedWriter bwriter = new BufferedWriter(writer);

		for (Person e : this.list) {

			bwriter.write(e.getInfo());

			bwriter.newLine();
		}

		bwriter.write(p.getInfo());
		list.add(p);

		bwriter.close();
	}

	public void delete(int num) throws IOException {

		list.remove(--num);
		save();

	}

	public void search(String search) {

		for (Person e : list) {
			if (e.getName().contains(search)) {
				e.showInfo();
			}

		}

	}

	public void revise(int num, Person p) throws IOException {

		delete(num);
		list.add(--num, p);
		save();

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
