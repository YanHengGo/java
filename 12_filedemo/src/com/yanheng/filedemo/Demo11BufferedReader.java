package com.yanheng.filedemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Demo11BufferedReader {

	public static void main(String[] args) throws Exception{

		demoReadSystemInput();
		demoReadFile();

	}

	private static void demoReadFile() throws Exception{
		File file = new File("d:"+File.separator+"99_temp"+File.separator+"outputstream"+File.separator+"readfile.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String temp;
		while ( (temp = bufferedReader.readLine()) != null  ) {
			System.out.println(temp);
		}
		bufferedReader.close();
	}

	private static void demoReadSystemInput() throws Exception{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("年齢入力してください：");
		while (true) {
			String string = bufferedReader.readLine();
			if (string.matches("\\d+")) {
				System.out.println(string);
				break;
			}else {
				System.out.println("年齢ではない,年齢入力してください：");
			}

		}
		bufferedReader.close();
	}

}
