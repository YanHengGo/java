package com.yanheng.filedemo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * System.in
 * System.out
 *
 * @author yanheng
 * 2018/11/18 17:57:48
 */
public class Demo10PrintStream {

	public static void main(String[] args) throws Exception {
		demoPrintWrite();
		demoPrintRead();
	}

	private static void demoPrintRead() throws Exception{
		InputStream inputStream = System.in;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.out.print("入力して：");
		int temp ;
		while ( (temp = inputStream.read()) !=-1) {
			if(temp == '\n') {
				break;
			}
			byteArrayOutputStream.write(temp);
		}
		System.out.println(new String(byteArrayOutputStream.toByteArray()));
	}

	private static void demoPrintWrite() throws Exception {
		OutputStream outputStream = System.out;
		outputStream.write("hello world !".getBytes());
	}

}
