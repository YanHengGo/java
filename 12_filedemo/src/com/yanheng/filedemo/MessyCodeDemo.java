package com.yanheng.filedemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
/**
 *
 * 文字化けテスト
 *
 * @author yanheng
 *
 */
public class MessyCodeDemo {

	public static void main(String[] args) throws Exception{
		//system properties output
		System.getProperties().list(System.out);
		System.out.println("-------");

		File file = new File("d:"+File.separator+"99_temp"+File.separator+"messycode.txt");
		OutputStream outputStream = new FileOutputStream(file);
		String string = "こんにちは ! \r\n";
		outputStream.write(string.getBytes());
		outputStream.write(string.getBytes("ISO8859-1"));
		outputStream.write(string.getBytes("GBK"));
		outputStream.write(string.getBytes("UTF-8"));
		outputStream.close();
	}

}
