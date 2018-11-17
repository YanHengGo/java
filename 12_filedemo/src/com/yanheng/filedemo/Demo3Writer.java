package com.yanheng.filedemo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class Demo3Writer {

	public static void main(String[] args) throws Exception {
		File file = new File("d:"+File.separator+"99_temp"+File.separator + "outputstream"+File.separator+"writedemo.txt");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		demoFileWriter(file);
		demoFileReader(file);
	}

	private static void demoFileWriter(File file) throws Exception{
		Writer writer = new FileWriter(file);
		String string = "this is writer demo  \r\n";
		writer.write(string);
		writer.close();
	}
	private static void demoFileReader(File file) throws Exception {
		Reader reader = new FileReader(file);
		char [] ch = new char[1024];
		int len = reader.read(ch);
		reader.close();
		System.out.println(new String(ch,0,len));
	}

}
