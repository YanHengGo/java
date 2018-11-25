package com.yanheng.filedemo;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

public class Demo13Input {



	public static void main(String[] args) throws Exception{
		File file = new File("d:"+File.separator+"99_temp"+File.separator+"outputstream"+File.separator+"readfile.txt");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
//		demoFileInputStream(file);
		demoFileReader(file);
		demoByteArrayInputStream();
	}

	private static void demoByteArrayInputStream() throws Exception {
		String string = "Hello Byte Array Input Stream";
		InputStream inputStream = new ByteArrayInputStream(string.getBytes());
		byte in_byte [] = new byte[1024];
		inputStream.read(in_byte);
		inputStream.close();
		System.out.println(new String(in_byte));
	}

	private static void demoFileReader(File file) throws Exception{
		Reader reader = new FileReader(file);
		char in_char [] = new char[1024];
		int len ;
		while ( (len = reader.read(in_char)) != -1 ) {
			System.out.println(new String(in_char,0,len));
		}
		reader.close();
	}

	private static void demoFileInputStream(File file) throws Exception {
		InputStream in = new FileInputStream(file);
		byte in_byte[] = new byte [1024];
		int len;
		while ( (len = in.read(in_byte)) != -1 ) {
			System.out.println(new String(in_byte,0,len));
		}
		in.close();
	}

}
