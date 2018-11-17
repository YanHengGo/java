package com.yanheng.filedemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class InputStreamReaderDemo {

	public static void main(String[] args) throws Exception{
		// TODO 自動生成されたメソッド・スタブ
		File file = new File("d:"+File.separator + "99_temp"+File.separator + "outputstream"+File.separator+"demoInputstream.txt");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		demo1(file);
		demo2(file);
	}

	private static void demo1(File file) throws Exception{
		OutputStream outputStream = new FileOutputStream(file);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		String str = "this is outputStreamWriter";
		outputStreamWriter.write(str);
		outputStreamWriter.close();
		outputStream.close();
	}

	private static void demo2(File file) throws Exception {
		InputStream inputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		char[] ch = new char[1024];
		int size= inputStreamReader.read(ch);
		System.out.println(new String(ch,0,size));
	}

}
