package com.yanheng.filedemo;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class ReaderDemo {

	public static void main(String[] args) throws Exception {
		File file = new File("d:"+File.separator+"99_temp"+File.separator+"outputstream"+File.separator+"writedemo.txt");
		if(!file.getParentFile().exists() ) {
			file.getParentFile().mkdirs();
		}
		demo1(file);

	}

	private static void demo1(File file) throws Exception {
		Reader reader = new FileReader(file);
		char [] ch = new char[1024];
		int len = reader.read(ch);
		reader.close();
		System.out.println(new String(ch,0,len));
	}

}
