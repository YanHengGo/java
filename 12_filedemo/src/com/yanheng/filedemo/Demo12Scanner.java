package com.yanheng.filedemo;

import java.io.File;
import java.util.Scanner;

public class Demo12Scanner {

	public static void main(String[] args) throws Exception{
//		demoSystemInputAge();
//		demoSystemInputDate();
		demoReadFile();
	}

	private static void demoReadFile() throws Exception{
		File file = new File("d:"+File.separator+"99_temp"+File.separator+"outputstream"+File.separator+"readfile.txt");
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\n");
		while(scanner.hasNext()) {
			System.out.print(scanner.next());
		}
		scanner.close();
	}

	private static void demoSystemInputDate() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("please input your birthday (yyyy-MM-dd) :");
		if(scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")) {
			System.out.println("your birthday is :"+scanner.nextLine());
		}else {
			System.out.println("format error");
		}
		scanner.close();
	}

	private static void demoSystemInputAge() {
		Scanner scanner = new Scanner(System.in);
//		scanner.useDelimiter("\n");
		System.out.print("please input your age :");
		if(scanner.hasNextInt()) {
			System.out.println("your age is "+scanner.next());
		}else {
			System.out.println("your input is not number");
		}
		scanner.close();
	}

}
