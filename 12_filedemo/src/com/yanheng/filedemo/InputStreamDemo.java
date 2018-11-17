package com.yanheng.filedemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamDemo {

	public static void main(String[] args) throws Exception {
		File file = new File("d:"+File.separator+"99_temp"+File.separator + "outputstream"+File.separator+"demo.txt");
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		demo1(file);
		demo2(file);
	}

	private static void demo2(File file) throws Exception{
		int temp = 0 , index = 0;
		byte [] bs = new byte[1024];
		InputStream inputStream = new FileInputStream(file);
		while((temp = inputStream.read())!=-1) {
			bs[index++]=(byte)temp;
		}
		System.out.println(new String(bs));
	}
	private static void demo1(File file) throws Exception{
		InputStream inputStream = new FileInputStream(file);
		byte[] bs = new byte[1024];
		inputStream.read(bs);
		inputStream.close();
		System.out.println(new String(bs));
	}

}
