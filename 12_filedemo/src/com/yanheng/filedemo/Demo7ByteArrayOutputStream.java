package com.yanheng.filedemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 内存流
 *
 * ByteArrayInputStream
 * ByteArrayOutputStream
 *
 * @author yanheng
 *
 * 2018/11/18 5:14:25
 */
public class Demo7ByteArrayOutputStream {

	public static void main(String[] args)  throws Exception {
		String string1 = "hello world !";
		InputStream inputStream = new ByteArrayInputStream(string1.getBytes());
		OutputStream outputStream = new ByteArrayOutputStream();

		int temp;

		while( (temp = inputStream.read() ) != -1 ) {
			outputStream.write(Character.toUpperCase(temp));
		}
		System.out.println(outputStream);
		inputStream.close();
		outputStream.close();
	}

}
