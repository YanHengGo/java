package com.yanheng.filedemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;

public class Demo14Output {

	public static void main(String[] args) throws Exception{
		File file = new File("d:"+File.separator+"99_temp"+File.separator+"outputstream"+File.separator+"output.txt");

		demoFileOutputStream(file);
		demoFileWriter(file);
	}

	private static void demoFileOutputStream(File file) throws Exception{
		OutputStream outputStream = new FileOutputStream(file);
		String string ="こんにちは\n";
		outputStream.write(string.getBytes());
		outputStream.close();
	}
	private static void demoFileWriter(File file) throws Exception{
		Writer writer = new FileWriter(file,true);
		String string = "さよなら  \r\n";
		writer.write(string);
		writer.close();
	}

}
