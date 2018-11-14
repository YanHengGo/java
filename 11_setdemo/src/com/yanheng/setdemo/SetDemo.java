package com.yanheng.setdemo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Person {
	String name ;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age セットする age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}


public class SetDemo {

	public static void main(String[] args) {

		demoHashSet();
		demoTreeSet();

	}

	private static void demoTreeSet() {
		Set<String> all = new TreeSet<>();
		all.add("Hello");
		all.add("ABC");
		all.add("World");
		all.add("BCD");
		System.out.println(all);

//		Set<Person> people = new TreeSet<Person>();
//		people.add(new Person("aa", 10));
//		System.out.println(people);
	}

	private static void demoHashSet() {
		Set<String> all = new HashSet<>();
		all.add("World");
		all.add("Hello");
		all.add("ABC");
		all.add("BCD");
		all.add("Y");
		System.out.println(all);
		Set<Person> people = new HashSet<>();
		people.add(new Person("tony", 25));
		System.out.println(people);



	}

}
