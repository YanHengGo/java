package com.yanheng.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
	private String name = "Tom";
	private int age = 16;
	public Person () {

	}
	public Person(String name ,int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}

public class DemoSerializable{

	public static void main(String[] args) {
		serializable(new Person());
		deserializable();
	}

	private static String filename = String.format("D:%s99_temp%sseri", File.separator,File.separator);

	private static void deserializable() {
		try {
			ObjectInputStream oInputStream = new ObjectInputStream(new FileInputStream(filename));
			Person person = (Person) oInputStream.readObject();
			System.out.println(person.toString());
			oInputStream.close();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	private static void serializable (Person person ) {
		try {
			ObjectOutputStream oOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
			oOutputStream.writeObject(person);
			oOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
