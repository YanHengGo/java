package com.yanheng.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;

class Person {
	private String name = "tony";
	private int age = 41;
	public Person() {

	}
	public Person(String name , int age ) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO 自動生成されたメソッド・スタブ
		return String.format("名前は%s,年齢は%d", name,age);
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

}


interface Fruit {
	void eat();
}
class Apple implements Fruit {
	@Override
	public void eat() {
		System.out.println("リンゴおいしい");
	}
}

class Lemon implements Fruit {

	@Override
	public void eat() {
		System.out.println("レモン酸っぱいよ");
	}

}
class FruitFactory {
	public static Fruit getInstance(String fruitName) {
		Fruit fruit = null;
		try {
			fruit = (Fruit) Class.forName(fruitName).newInstance();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return fruit;
	}
}

public class ReflectDemo {

	public static void main(String[] args) {
		//クラス取得する
		demoClassName();
		//インスタンス作成
		demoCreateInstance();
		//ファクトリーパターン
		demoFactory();
		//インスタンス作成（パラメータあり）
		demoConstructor();
		//メソッド 呼ぶ
		demoMethod();
		//変数　呼ぶ
		demoLocalVariable();
	}

	private static void demoLocalVariable() {
		Person person;
		Class<?> clazz;
		Field fieldName;
		Field fieldAge;

		try {
			clazz = Class.forName("com.yanheng.reflect.Person");
			person = (Person) clazz.newInstance();

			fieldName = clazz.getDeclaredField("name");
			fieldName.setAccessible(true);
			fieldName.set(person, "Jack");

			fieldAge = clazz.getDeclaredField("age");
			fieldAge.setAccessible(true);
			fieldAge.set(person, 23);

			System.out.println(person.toString());
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	private static void demoMethod() {
		Person person;
		Class<?> clazz;
		Method methodsetName;
		Method methodSetAge;
		try {
			clazz = Class.forName("com.yanheng.reflect.Person");
			person = (Person) clazz.newInstance();
			methodsetName = clazz.getMethod("setName", String.class);
			methodSetAge = clazz.getMethod("setAge", int.class);
			methodsetName.invoke(person, "Tom");
			methodSetAge.invoke(person, 32);
			System.out.println(person.toString());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	private static void demoConstructor() {
		try {
			Class<?> clazz = Class.forName("com.yanheng.reflect.Person");
			Constructor constructor = clazz.getConstructor(String.class , int.class);
			Person person = (Person) constructor.newInstance("阿部",25);
			System.out.println(person.toString());
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	private static void demoFactory() {
		String name = "com.yanheng.reflect.Apple";
		Fruit fruit = FruitFactory.getInstance(name);
		fruit.eat();

		name = "com.yanheng.reflect.Lemon";
		Fruit fruit2 = FruitFactory.getInstance(name);
		fruit2.eat();
	}

	private static void demoCreateInstance() {
		Class<?> class3;
		try {
			class3 = Class.forName("com.yanheng.reflect.Person");

			Person person = (Person) class3.newInstance();
			System.out.println(person.toString());
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}

	private static void demoClassName()  {
		Class<?> class1 = Date.class;
		System.out.println("--Date.class--");
		System.out.println(class1.getName());
		System.out.println(class1.getSimpleName());

		java.util.Date date = new java.util.Date();
		Class<?> class2 = date.getClass();
		System.out.println("--date.getClass()--");
		System.out.println(class2.getName());
		System.out.println(class2.getSimpleName());

		Class<?> class3;
		try {
			class3 = Class.forName("com.yanheng.reflect.Person");
			System.out.println(class3.getName());
			System.out.println(class3.getSimpleName());
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}

	}

}
