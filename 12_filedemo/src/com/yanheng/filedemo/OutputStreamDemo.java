package com.yanheng.filedemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamDemo {

	public static void main(String[] args) throws Exception {
		File file = new File("d:"+File.separator+"99_temp"+File.separator + "outputstream"+File.separator+"demo.txt");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		demo1(file);
		demo2(file);
		demo3(file);
	}

	static String nextLine = "\r\n";
	private static void demo1(File file) throws Exception {
		String string = "output stream demo1";
		OutputStream output = new FileOutputStream(file);  //既存内容削除
		output.write(string.getBytes());
		output.write(nextLine.getBytes());
		output.close();
	}
	private static void demo2(File file) throws Exception{
		String string = "output stream demo2 ";
		OutputStream output = new FileOutputStream(file , true);  //内容追加
		output.write(string.getBytes() , 0 , 10);
		output.write(nextLine.getBytes());
		output.close();
	}
	private static void demo3(File file) throws Exception{
		String string = "output stream demo3 ";
		OutputStream output = new FileOutputStream(file , true);  //内容追加
		byte[] byte1 = string.getBytes();
		for (int i =0;i<byte1.length ;i++) {
			output.write(byte1[i]);
		}
		output.write(nextLine.getBytes());
		output.close();
	}

}
